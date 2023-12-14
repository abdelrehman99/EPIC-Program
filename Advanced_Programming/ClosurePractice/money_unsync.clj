(def wallets
    {
        "John" (atom 100)
        "Kate" (atom 200)
        "Pete" (atom 300)
        "Bill" (atom 400)
        "Jack" (atom 500)
        "Jill" (atom 600)
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
        (let [amount (rand-int (max 1 (min 11 (+ 1 @from-wallet))))]
            (when (not= amount 0)
                (swap! from-wallet #(- % amount))
                (swap! to-wallet #(+ % amount))))))

(def futures (for [_ (range 2)
                   from (keys wallets)]
    (future
        (doseq [_ (range 10000)]
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