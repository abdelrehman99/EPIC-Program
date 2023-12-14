(def wallets
    {
        "John" (ref 100)
        "Kate" (ref 200)
        "Pete" (ref 300)
        "Bill" (ref 400)
        "Jack" (ref 500)
        "Jill" (ref 600)
    })

(def users (apply vector (keys wallets)))

(defn transfer
    [from]
    (let [from-wallet (wallets from)
          to (loop []
                (let [user (rand-nth users)]
                    (if (= user from)
                        (recur)
                        user)))
          to-wallet (wallets to)]
        (dosync
            (let [amount (rand-int (min 11 (+ 1 @from-wallet)))]
                (when (not= amount 0)
                    (alter from-wallet #(- % amount))
                    (alter to-wallet #(+ % amount)))))))

(def futures (for [_ (range 2)
                   from (keys wallets)]
    (future
        (doseq [_ (range 1000)]
            (transfer from)))))

(def done (atom false))

(def watcher
    (future
        (loop []
            (when-not @done
                (doseq [[name amount] wallets]
                    (let [a @amount]
                        (when (< a 0)
                            (throw (Exception. (str "user " name " has negative amount " a))))))
                (recur)))))

(doseq [f (doall futures)] @f)
(reset! done true)
@watcher
(doseq [[name amount] wallets] (println name @amount))
(shutdown-agents)