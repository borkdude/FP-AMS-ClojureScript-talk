# FPAMSCLJ

Comparative example of Reagent and Om.

# Running the project (with figwheel and weasel)

In one terminal:

    lein figwheel (om|reagent)

In another:

    lein ring server

To interact from the browser REPL:

```
$ cd example
$ lein repl
example.api=> (brepl) ;; starts browser repl
```

Finally browse to
[http://localhost:8090/index.html](http://localhost:8090/index.html)
and have fun.

## Running the project without figwheel and weasel:

Use normal `lein cljsbuild` +

```
IS_DEV=false lein ring server
```

## License

Copyright Michiel Borkent and Vijay Kiran

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
