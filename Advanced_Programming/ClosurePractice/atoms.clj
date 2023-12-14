(def atoms (for [_ (range 5)] (atom 0)))
(def futures (for [_ (range 8)]
    (future
        (doseq [_ (range 10000)
                a atoms]
            (swap! a + 1)))))
(doseq [f (doall futures)] @f)
(doseq [a atoms] (println @a))
(shutdown-agents)