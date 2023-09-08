(ns hash-s-test
  (:require [hash-s :refer [s*]]
            [clojure.test :refer [deftest is]]))

(def first-name "mike")
(def last-name "wazowski")
(def sentence "You played dodgeball? I loved dodgeball! Of course, I was the ball.")
;; (def flo 1.4)
;; (def in 2137)
;; (def m {:a 1}) ;; TODO: maps are problematic as their string representation contains curly brackets
;; (def v [1 2])

(deftest s*-test
  (binding [*data-readers* {'s #(s* %)}] ;; TODO
    (is (= "\"You played dodgeball? I loved dodgeball! Of course, I was the ball.\" - mike wazowski said."
           #_(read-string "#s \"\"{sentence}\" - {first-name} {last-name} said.\"")
           (s* "\"{sentence}\" - {first-name} {last-name} said.")))

    (let [flo 1.4
          in 2137
          m {:a 1}
          v [1 2]]
      (is (= "1.4 2137 [1 2]"
             (s* "{flo} {in} {v}"))))))
