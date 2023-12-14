(def agents (for [_ (range 5)] (agent 0)))
(def futures (for [_ (range 8)]
    (future
        (doseq [_ (range 10000)
                a agents]
            (send a + 1)))))
(doseq [f (doall futures)] @f)
(doseq [a agents] (println @a))
(doseq [a agents] (await a) (println @a))
(shutdown-agents)