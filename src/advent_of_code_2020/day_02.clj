(ns advent-of-code-2020.day-02)

(defn read-file [resource-name] (clojure.string/split-lines (slurp (clojure.java.io/resource resource-name))))

; Part 1

(defn count-char-occurrences
  [selected-char string-to-check]
  (count (re-seq (re-pattern selected-char) string-to-check)))

(defn is-line-valid-by-count
  [line]
  (let [my-line (re-matches #"^(\d+)-(\d+) (\w): (\w+)$" line)
        min-chars (Integer/parseInt (get my-line 1))
        max-chars (Integer/parseInt (get my-line 2))
        selected-char (get my-line 3)
        password (get my-line 4)]
    (<= min-chars
        (count-char-occurrences selected-char password)
        max-chars)))

(count (filter is-line-valid-by-count (read-file "day_02_input_short.txt")))
(count (filter is-line-valid-by-count (read-file "day_02_input.txt")))

; Part 2

(defn count-matching-indexes
  [first-index second-index selected-char password]
  (+ (if (= (String/valueOf (get password first-index)) (String/valueOf selected-char)) 1 0)
     (if (= (String/valueOf (get password second-index)) (String/valueOf selected-char)) 1 0)))

(defn is-line-valid-by-position
  [line]
  (let [my-line (re-matches #"^(\d+)-(\d+) (\w): (\w+)$" line)
        first-index (- (Integer/parseInt (get my-line 1)) 1)
        second-index (- (Integer/parseInt (get my-line 2)) 1)
        selected-char (get my-line 3)
        password (get my-line 4)]
    (= (count-matching-indexes first-index second-index selected-char password) 1)))

(count (filter is-line-valid-by-position (read-file "day_02_input_short.txt")))
(count (filter is-line-valid-by-position (read-file "day_02_input.txt")))
