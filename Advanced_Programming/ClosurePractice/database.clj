(def people [{:name "John"
              :age 26
              :occupation "Developer"
              :gender :male}
             {:name "Steve"
              :age 31
              :occupation "Manager"
              :gender :male}
             {:name "Peter"
              :age 18
              :occupation "Tester"
              :gender :male}
             {:name "Kate"
              :age 24
              :occupation "Developer"
              :gender :female}
             {:name "Sarah"
              :age 35
              :occupation "Manager"
              :gender :female}
             {:name "Annah"
              :age 23
              :occupation "Developer"
              :gender :female}])

; Print the number of people
(println (count people))

; Print the ages of people
(println (map :age people))

; Print all the managers
(println (filter #(= (:occupation %) "Manager") people))

; Print the names of all the managers (list comprehension style)
(println
 (for [p people :when (= (:occupation p) "Manager")]
   (:name p)))

; Print the names of all the managers
(println (map #(:name %)
              (filter #(= (:occupation %) "Manager")
                      people)))

; List all possible occupations
(println (set (map :occupation people)))

; Print developers' names ordered by age
(println
 (map :name
      (sort-by
       :age
       (filter #(= (:occupation %) "Developer") people))))

; Print all possible pairs of a developer and a manager
(println
 (for [x people
       :when (= (:occupation x) "Developer")
       y people
       :when (= (:occupation y) "Manager")]
   [x y]))

; Print all possible pairs of a developer and a manager, ordered by sum of ages
(println
 (sort-by #(+ (:age (first %1)) (:age (second %1)))
          (for [x people
                :when (= (:occupation x) "Developer")
                y people
                :when (= (:occupation y) "Manager")]
            [x y])))