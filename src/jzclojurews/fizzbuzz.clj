(ns fizzbuzz
  (:use clojure.test))

(defn fizz-buzz [number]
  (cond (= (rem number 15) 0) "fizzbuzz"
        (= (rem number 3) 0) "fizz"
        (= (rem number 5) 0) "buzz"
        :else                 number))

;(map (fn [x] (+ x 2)) [1 2 3 4])