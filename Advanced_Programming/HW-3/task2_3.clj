(def my_list (for [x (range 5)
                   y (range x 5)
                   z (range x 5)
                   :when (<= (+ (* x x) (* y y)) (* z z))]
               [x y z]))

(println (sort-by #(apply + %) my_list))

