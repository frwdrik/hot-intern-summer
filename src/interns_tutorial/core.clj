(ns interns-tutorial.core)

(def interns
  [{:name "Ilaria"
    :country "Italy"
    :age 22}
   {:name "Eirik"
    :country "Norway"
    :age 23}
   {:name "Jonas"
    :country "Norway"
    :age 22}])

;; average = (sum of ages) / (length of ages)

(defn sum-of-ages [ages]
  (apply + ages))

(defn average-age [people]
  (float
   (/ (sum-of-ages (map :age people))
      (count people))))

(average-age interns)

(group-by :country interns)

(defn is-upper-case [c]
  (if (java.lang.Character/isUpperCase c)
    :upper
    :lower))

(group-by is-upper-case "fooBaARAtr")

(->> (frequencies "Eirik")
     (apply max-key val)
     key)
;; is the same as
(key (apply max-key val (frequencies "Eirik")))

(+ 1 1)
