(def my_list (for [x (range 5)
                   y (range x 5)
                   :when (<= x y)]
               [x y]))

(println (sort-by #(apply + %) my_list))

