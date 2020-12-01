(ns advent-of-code-2020.day_01
  (:use [clojure.math.combinatorics])
  )

(defn totals_2020 [x] (= (apply + x) 2020))

; Part 1
(map (fn [x] (apply * x))
     (filter totals_2020
             (into [] (
                        map (fn [x] (into [], x))
                            (combinations
                              (map #(Integer/parseInt %)
                                   (clojure.string/split-lines (slurp (clojure.java.io/resource "day_01_input_short.txt"))))
                              2
                              )
                            )
                   )
             ))

(map (fn [x] (apply * x))
     (filter totals_2020
             (into [] (
                        map (fn [x] (into [], x))
                            (combinations
                              (map #(Integer/parseInt %)
                                   (clojure.string/split-lines (slurp (clojure.java.io/resource "day_01_input.txt"))))
                              2
                              )
                            )
                   )
             ))

; Part 2
(map (fn [x] (apply * x))
     (filter totals_2020
             (into [] (
                        map (fn [x] (into [], x))
                            (combinations
                              (map #(Integer/parseInt %)
                                   (clojure.string/split-lines (slurp (clojure.java.io/resource "day_01_input.txt"))))
                              3
                              )
                            )
                   )
             ))


