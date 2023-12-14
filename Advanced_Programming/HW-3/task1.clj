(def cities [{:name "Tokyo"
              :country "Japan"
              :population 39105000
              :area 8231}
             {:name "Delhi"
              :country "India"
              :population 31870000
              :area 2233}
             {:name "Shanghai"
              :country "China"
              :population 22118000
              :area 4069}
             {:name "Sao Paulo"
              :country "Brazil"
              :population 22495000
              :area 1521}
             {:name "Mexico City"
              :country "Mexico"
              :population 21505000
              :area 2385}
             {:name "Cairo"
              :country "Egypt"
              :population 19787000
              :area 2010}
             {:name "Mumbai"
              :country "India"
              :population 22186000
              :area 1008}
             {:name "Beijing"
              :country "China"
              :population 19437000
              :area 4172}
             {:name "Dhaka"
              :country "Bangladesh"
              :population 16839000
              :area 456}
             {:name "Osaka"
              :country "Japan"
              :population 15490000
              :area 3020}
             {:name "New York"
              :country "United States"
              :population 23582649
              :area 34493}
             {:name "Karachi"
              :country "Pakistan"
              :population 15292000
              :area 1044}
             {:name "Buenos Aires"
              :country "Argentina"
              :population 16216000
              :area 3222}
             {:name "Chongqing"
              :country "China"
              :population 8261000
              :area 1356}
             {:name "Istanbul"
              :country "Turkiye"
              :population 15311000
              :area 1375}
             {:name "Kolkata"
              :country "India"
              :population 18698000
              :area 1352}
             {:name "Manila"
              :country "Philippines"
              :population 23971000
              :area 1873}
             {:name "Lagos"
              :country "Nigeria"
              :population 15487000
              :area 1966}
             {:name "Rio de Janeiro"
              :country "Brazil"
              :population 12486000
              :area 2020}
             {:name "Tianjin"
              :country "China"
              :population 10932000
              :area 2813}])

(def countries [{:name "Pakistan"
                 :continent "Asia"}
                {:name "Argentina"
                 :continent "South America"}
                {:name "Turkiye"
                 :continent "Asia"}
                {:name "Brazil"
                 :continent "South America"}
                {:name "United States"
                 :continent "North America"}
                {:name "Bangladesh"
                 :continent "Asia"}
                {:name "Mexico"
                 :continent "North America"}
                {:name "Egypt"
                 :continent "Africa"}
                {:name "Japan"
                 :continent "Asia"}
                {:name "Nigeria"
                 :continent "Africa"}
                {:name "Philippines"
                 :continent "Asia"}
                {:name "China"
                 :continent "Asia"}
                {:name "India"
                 :continent "Asia"}
                {:name "DR Congo"
                 :continent "Africa"}
                {:name "Russia"
                 :continent "Europe"}
                {:name "France"
                 :continent "Europe"}])

; You are given the database about cities and countries (see above).
;
; You need to answer some queries usig Clojure. It is highly recommended to
; use the functions such as map, filter, reduce and sort-by. You can also use
; list comprehensions.
;
; The only data you can use is the data from the databases above.

; 1. Print the number of unique countries in the cities database
(println (count (distinct countries)))

;;  2. Print the total area of the cities located in China
(def filtered (filter #(= (:country %) "China") cities))
(println (reduce + (map :area filtered)))

;;  3. Print the names of the cities located in India
(def filtered2 (filter #(= (:country %) "India") cities))
(println(map :name filtered2))

;;  4. Print the names of top five cities with the largest area
(def sorted_areas (map :name
                       (sort-by
                        :area cities)))
(println (take-last 5 sorted_areas) )

; 5. Print the names of top five cities with the largest population density
(def sorted_population (map :name
                       (sort-by
                        :population cities)))
(println (take-last 5 sorted_population))

;;  6. Print the number of cities located in Asia
(def Asia_countries (map :name (filter #(= (:continent %) "Asia") countries)))

(def Num_Asia_citis (count
                     (for [city cities country Asia_countries :when (= (:country city) country)]
                       (:name city))))

(println Num_Asia_citis)

; 7. Print the names of top five cities with the smaller area, alongside with their continent.
(def least_area (take 5 (sort-by
                         :area cities)))

(println (for [city least_area
               country countries
               :when (= (:country city) (:name country))]
           [(:name city) (:continent country)]))

; 8. Print the total area of the cities located in South America
(def SA_countries (map :name (filter #(= (:continent %) "South America") countries)))

(def SA_cities_areas (for [city cities country SA_countries :when (= (:country city) country)]
  (:area city)))

(println (reduce + SA_cities_areas))

; 9. Print the total population of the cities for each country. Hint: use group-by
(def groups (group-by :country cities))

(println (for [[country city] groups] [country (reduce + (map :population city))]))


; 10. Print the largest city by population for each country
(println (for [[country city] groups] [country (take-last 1 (map :name (sort-by :population city)))]))

; 11. Print the total population of the cities for each continent
(def continent_groups (group-by :continent countries))

(println (for [[continent country] continent_groups]
           [continent
            (reduce +
                    (for [con country]
                      (reduce +
                              (map :population
                                   (get groups (:name con))))))]))

; 12. Print the names of the cities whose area is larger than the average area of a city in Asia.
;     The cities to be printed can be from any continent.
(def Asia_area (reduce + (for [con (get continent_groups "Asia")]
                 (reduce +
                         (map :area
                              (get groups (:name con)))))))

(def average (/ Asia_area Num_Asia_citis))

(println (for [city cities :when(> (:area city) average)] (:name city)))