(ns hash-s-test
  (:require [hash-s :refer [s*]]
            [clojure.test :refer [deftest is]]))

(deftest s*-test
  (binding [*data-readers* {'s #(s* %)}] ;; TODO
    (let [first-name "mike"
          last-name "wazowski"
          sentence "You played dodgeball? I loved dodgeball! Of course, I was the ball."]

      (is (= "\"You played dodgeball? I loved dodgeball! Of course, I was the ball.\" - mike wazowski said."
             (s* "\"{sentence}\" - {first-name} {last-name} said."))))

    (let [flo 1.4
          in 2137
          m {:a 1} ;; TODO
          v [1 2]]
      (is (= "1.4 2137 [1 2]"
             (s* "{flo} {in} {v}"))))))
