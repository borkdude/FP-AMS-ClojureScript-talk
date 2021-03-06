(ns fpamsclj.animals
  (:require [fpamsclj.db :as db]))

(defn create!
  ([]
     (db/create! {:type :animal}))
  ([m]
     (db/create! (assoc m :type :animal))))

(defn read
  ([]
     (db/read :type :animal))
  ([id]
     (db/read id))
  ([k v]
     (db/read k v)))

(defn update!
  [id m]
  (db/update! id m))

(defn delete!
  [id]
  (db/delete! id))

(defn init
  []
  (do
    (create! {:name    "Painted-snipe"
              :class   :aves
              :species "Rostratulidae"})

    (create! {:name    "Yellow-backed duiker"
              :class   :mammalia
              :species "Cephalophus silvicultor"})

    (create! {:name    "Aardwolf"
              :class   :mammalia
              :species "Proteles cristata"})

    (create! {:name    "Gnu"
              :class   :mammalia
              :species "Connochaetes gnou"})

    (create! {:name    "Curled octopus"
              :class   :cephalopoda
              :species "Eledone cirrhosa"})

    (create! {:name    "Horny toad"
              :class   :reptilia
              :species "Phrynosoma cornutum"})

    (create! {:name    "Dung beetle"
              :class   :insecta
              :species "Scarabaeus sacer"})

    (create! {:name    "Atlantic salmon"
              :class   :osteichthyes
              :species "Salmo salar"})
    ))
