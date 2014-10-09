(ns fpamsclj.om
  (:require-macros [cljs.core.async.macros :refer (go)])
  (:require
    [om.core :as om :include-macros true]
    [om.dom :as dom :include-macros true]
    [cljs-http.client :as http]
    [cljs.core.async :refer (<!)]
    [figwheel.client :as fw]
    [weasel.repl :as ws-repl]))

(enable-console-print!)

(defonce init-dev
  ;; we need to defonce this, so it won't be executed again upon code
  ;; reload
  (go (let [body (:body (<! (http/get "/is-dev")))]
        (when (= body true) ;; has to match exactly true and not some string
          (fw/watch-and-reload
           :websocket-url   "ws://localhost:3449/figwheel-ws"
           :jsload-callback
           (fn []
             (println "reloaded")))
          (ws-repl/connect "ws://localhost:9001" :verbose true)))))

(defonce app-state (atom {:text ""}))

(om/root
 (fn [app owner]
   (reify
     om/IWillMount
     (will-mount [_]
       (go (let [response (<! (http/get
                               (str "/greeting")))]
             (if (= (:status response)
                    200)
               (om/update! app :text (:body response))
               (om/update! app :text "Server error")))))
     om/IRender
     (render [_]
       (dom/h1 nil (:text app)))))
 app-state
 {:target (. js/document (getElementById "app"))})
