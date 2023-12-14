(def refs (for [_ (range 5)] (ref 0)))
(def futures (for [_ (range 8)]
    (future
        (doseq [_ (range 10000)
                r refs]
            (dosync
                ; (alter r + 1)
                (alter r (partial + 1))))
        42)))
(doseq [f (doall futures)] (println @f))
(doseq [r refs] (println @r))
(shutdown-agents)