;Print first six Fibonacci numbers divisible by 7.

(defn fib
  ([] (fib 0 1))
  ([a b] (lazy-seq (cons b (fib b (+ a b))))))

(def fib_list (take 70 (fib)))

(println (take 6 (for [x fib_list :when (= (mod x 7) 0)] x)))