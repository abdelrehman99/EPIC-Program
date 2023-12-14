(def wallets
    (agent {
        "John" 100
        "Kate" 200
        "Pete" 300
        "Bill" 400
        "Jack" 500
        "Jill" 600
    }))

(def users (apply vector (keys @wallets)))

(defn transfer
    [from]
    (let [
          to (loop []
                (let [user (rand-nth users)]
                    (if (= user from)
                        (recur)
                        user)))]
        (send wallets (fn [wallets]
            (let [from-wallet (wallets from)
                  to-wallet (wallets to)
                  amount (rand-int (min 11 (+ 1 from-wallet)))]
                (if (not= amount 0)
                    (update (update wallets to #(+ % amount)) from #(- % amount))
                    wallets))))))

(def futures (for [_ (range 2)
                   from users]
    (future
        (doseq [_ (range 1000)]
            (transfer from)))))

(def done (atom false))

(def watcher
    (future
        (loop []
            (when-not @done
                (doseq [[name amount] @wallets]
                    (let [a amount]
                        (when (< a 0)
                            (throw (Exception. (str "user " name " has negative amount " a))))))
                (recur)))))

(doseq [f (doall futures)] @f)
(await wallets)
(reset! done true)
@watcher
(doseq [[name amount] @wallets] (println name amount))
(shutdown-agents)