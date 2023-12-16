(println (take 100 (filter
                    #(loop [i 2]
                       (if (> (* i i) %1)
                         true
                         (if (= (mod %1 i) 0)
                           false
                           (recur (inc i)))))
                    (drop 2 (range)))))
