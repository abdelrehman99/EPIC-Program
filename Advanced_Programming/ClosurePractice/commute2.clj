(def refs (for [_ (range 5)] (ref 0)))
(def futures (for [_ (range 8)]
    (future
        (doseq [_ (range 10000)
                r refs]
            (dosync
                (if (== @r 70000)
                    ; (commute r (fn [_] 80001))
                    (ref-set r 80001)
                    (commute r + 1)))))))
(doseq [f (doall futures)] @f)
(doseq [r refs] (println @r))
(shutdown-agents)