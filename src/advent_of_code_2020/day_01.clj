(ns advent-of-code-2020.day_01
  (:use [clojure.math.combinatorics])
  )

(defn read-file [resource-name] (clojure.string/split-lines (slurp (clojure.java.io/resource resource-name))))
(defn read-ints-from-file [resource-name] (map #(Integer/parseInt %) (read-file resource-name)))
(defn get-combinations [items num] (map (fn [x] (into [], x)) (combinations items num)))
(defn totals-2020 [x] (= (apply + (into [] x)) 2020))

(defn product-of-entries-that-sum-to-2020
  [entries num-of-entries]
  (map (fn [x] (apply * x))
       (filter totals-2020
               (get-combinations entries num-of-entries)))
  )

; Part 1
(product-of-entries-that-sum-to-2020 (read-ints-from-file "day_01_input_short.txt") 2)
(product-of-entries-that-sum-to-2020 (read-ints-from-file "day_01_input.txt") 2)

; Part 2
(product-of-entries-that-sum-to-2020 (read-ints-from-file "day_01_input.txt") 3)
