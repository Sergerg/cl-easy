(ns cl-easy.rome
  (:require [clojure.string :as str])
  (:gen-class))

;; Римские цифры! Kata2
;; I - 1
;; V - 5
;; X - 10
;; L - 50
;; C - 100
;; D - 500
;; M - 1000

;; 449 CDXLIX
;; 989 CMLXXXIX
;; 990 CMXC 
;; 991 CMXCI 
;; 992 CMXCII 
;; 993 CMXCIII 
;; 994 CMXCIV 
;; 995 CMXCV 
;; 996 CMXCVI 
;; 997 CMXCVII 
;; 998 CMXCVIII 
;; 999 CMXCIX

(defn char-to-num
  "Символ в число"
  [c]
  (case c
   "I" 1 "V" 5 "X" 10 "L" 50 "C" 100 "D" 500 "M" 1000 
    nil))

;; (char-to-num "I")
;; (char-to-num "V")
;; (char-to-num nil)
;; (char-to-num 1)

(defn str-to-rome-num
  ""
  [str]
  (map char-to-num (str/split str #"")))

;; (str-to-rome-num "XVI")

(defn make-pairs
  "Пары в списке"
  [l]
  (conj (mapv vector l (drop 1 l))
        (vector (last l) 1)))

;; (make-pairs (str-to-rome-num "XVI"))
;; (make-pairs (str-to-rome-num "XIV"))

(defn count-num
  "Веса позиций"
  [v]
  (mapv #(let [i1 (% 0) i2 (% 1)]
           (if (< i1 i2) (- i1) i1))
        v))

;; (count-num (make-pairs (str-to-rome-num "XIV")))

(defn translate-roman-numerals-1
  "Римские цифры в арабские"
  [str]
  (reduce + (count-num (make-pairs (str-to-rome-num str)))))

(defn translate-roman-numerals
  "Римские цифры в арабские"
  [str]
  ;;(reduce + (count-num (make-pairs (str-to-rome-num str))))
  (->> str
       (str-to-rome-num)
       (make-pairs)
       (count-num)
       (reduce +)))

;; Для проверки в репле...
(comment
  (translate-roman-numerals "XXX")
  (translate-roman-numerals "XVI")
  (translate-roman-numerals "XIV")
  (translate-roman-numerals "CDXLIX")
  (translate-roman-numerals "CMXCIX")
  )



