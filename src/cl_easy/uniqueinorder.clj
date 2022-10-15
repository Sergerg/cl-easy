(ns cl-easy.uniqueinorder
  (:require [clojure.string :as str])
  (:gen-class))

;; AAABCCcAAA -> [\A \B \C \c \A]

(defn uniqueInOrderList [l]
  (loop [n (first l) list (rest l) res []] ;; this works just like a 'let' binding.
    (println n list res)
    ;;(println "===" (= n (first list)))
    (if (= (count list) 0)  ;; this is the base case.
      (if (= n (first list)) res (conj res n))
      (recur
       (first list)
       (rest list)
       (if (= n (first list)) res (conj res n))))))

(defn unique-in-order [input]
  (->> input
      (seq)
      (uniqueInOrderList))
  )

(comment
  ;; Отладка?
  (uniqueInOrderList '(1 2 3 -1 -1 4))
  (uniqueInOrderList [1 2 3 3])

  (unique-in-order "123")
  (unique-in-order "aaaSSSwwwЫЫЫ1ыЦЦЦЦ")
  (unique-in-order [1 2 3])

  (str/split "123" #"")
  (= 1 1)

  (count '())

  (unique-in-order "aaasss")
  (unique-in-order [1 2 3])

  (set [1 2 2])
  
  (seq "123")
  (seq "aaaSSSwwwЫЫЫ1ыЦЦЦЦ")
  (seq [1 2 3])
  (seq '(1 2 3))

  )


