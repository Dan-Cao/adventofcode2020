(ns advent-of-code-2020.day-03)

(defn read-file [resource-name] (clojure.string/split-lines (slurp (clojure.java.io/resource resource-name))))


; Part 1

(defn tree-at-pos
  [map-line pos]
  (if (= (nth (cycle map-line) pos) \#) 1 0))

(defn index-map-lines
  [map-lines]
  (map-indexed vector map-lines))

(defn get-trees
  [map-lines]
  (map (fn [line-index-and-content]
         (let [line-num (get line-index-and-content 0)
               map-line (get line-index-and-content 1)]
           (tree-at-pos map-line (* line-num 3))))
       (index-map-lines map-lines)))

(reduce + (get-trees (read-file "day_03_input_short.txt")))
(reduce + (get-trees (read-file "day_03_input.txt")))

; Part 2

(defn get-trees-with-slope
  [map-lines right down]
  (map (fn [line-index-and-content]
         (let [line-num (get line-index-and-content 0)
               map-line (get line-index-and-content 1)]
           (tree-at-pos map-line (* line-num right))))
        (index-map-lines (take-nth down map-lines))))

(defn get-trees-count-with-slope
  [map-lines right down]
  (reduce + (get-trees-with-slope map-lines right down)))

(let [map-lines (read-file "day_03_input_short.txt")]
  (reduce * [(get-trees-count-with-slope map-lines 1 1)
             (get-trees-count-with-slope map-lines 3 1)
             (get-trees-count-with-slope map-lines 5 1)
             (get-trees-count-with-slope map-lines 7 1)
             (get-trees-count-with-slope map-lines 1 2)]))

(let [map-lines (read-file "day_03_input.txt")]
  (reduce * [(get-trees-count-with-slope map-lines 1 1)
             (get-trees-count-with-slope map-lines 3 1)
             (get-trees-count-with-slope map-lines 5 1)
             (get-trees-count-with-slope map-lines 7 1)
             (get-trees-count-with-slope map-lines 1 2)]))
