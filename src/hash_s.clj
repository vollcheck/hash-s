(ns hash-s
  (:require [clojure.string :refer [replace-first]]))

(def ^:private pattern #"\{(.*?)\}")

(defmacro s* [s]
  ;; they come in pairs of ([{firstname} firstname] ...), get the last one from each pair
  `(->> (re-seq ~pattern ~s)
        (map (fn [[_curled# var#]]
               (if-let [v# (resolve (symbol var#))]
                 @v#
                 (throw (Exception. (str "No such var for replacement: " var#))))))
        (reduce (fn [agg# v#]
                  (replace-first agg# ~pattern (str v#)))
                ~s)))
