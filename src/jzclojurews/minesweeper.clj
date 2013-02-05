(ns minesweeper
  (:use clojure.test))

(def board [[nil   :mine nil   nil  ]
            [:mine nil   nil   nil  ]
            [nil   nil   :mine nil  ]
            [:mine nil   nil   :mine]])

(with-test
 (defn within-board? 
     [board c]
     (and 
      (< -1 (first c) (count board))
      (< -1 (second c) (count (first board)))
     )
 )
  (is (true? (within-board? board [0 0])))
  (is (true? (within-board? board [0 2])))
  (is (false? (within-board? board [-1 -1])))
  (is (false? (within-board? board [13 37])))
 
 )

(with-test
    (defn mine?
      "Returns true if cell c contains a mine, false otherwise."
      [board c]
        (and 
         (within-board? board c)
         (= :mine ((board (first c))(second c))))
        )
  
  (is (true? (mine? board [0 1])))
  (is (false? (mine? board [0 2])))
  (is (false? (mine? board [-1 -1])))
  (is (false? (mine? board [13 37])))
  )

(with-test
    (defn neighbours
      "For a cell c, return a list of the cell's neighbours."
      [c]
      
       (let [
            modifier [-1 0 1]
            naboer  
                  (mapcat 
                     (fn [y]
                         (map (fn [x] [(+ (first c) y) (+ (second c) x)]) modifier)
                     ) modifier)
       ]
              (concat (take 4 naboer) (drop 5 naboer))
       )
            
      )

  (is (= [[-1 -1] [-1 0] [-1 1] [0 -1] [0 1] [1 -1] [1 0] [1 1]]
         (neighbours [0 0])))
  (is (= [[1 2] [1 3] [1 4] [2 2] [2 4] [3 2] [3 3] [3 4]]
         (neighbours [2 3])))
)

(with-test
    (defn mines
      "For a cell c, return the number of mines adjacent to it."
      [board c]
      nil)

;  (is (= 3 (mines board [1 1])))
;  (is (= 0 (mines board [0 3])))
;  (is (= 2 (mines board [3 2])))
)