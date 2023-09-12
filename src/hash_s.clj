(ns hash-s
  (:require [clojure.string :refer [replace-first]]))

(def pattern #"\{(.*?)\}")

(defmacro s* [s]
  (let [ls (into {} (for [sym (keys &env)]
                      [#_(list 'quote sym) (-> sym name keyword) sym]))]
    `(->> (re-seq ~pattern ~s)
          (map (fn [[_curled# var#]]
                 (if-let [v# (resolve (symbol var#))]
                   @v#
                   (if-let [v# (get ~ls (-> var# name keyword))]
                     v#
                     (throw (Exception. (str "No such var for replacement: " var#)))))))
          (reduce (fn [agg# v#]
                    (replace-first agg# ~pattern (str v#)))
                  ~s))))
