(ns interns-tutorial.ice-cream-store)

(def recipes
  ;; every quantity is in grams
  {:pistaccio [{:name :pistaccio-nuts
                :quantity 20}
               {:name :milk
                :quantity 100}
               {:name :sugar
                :quantity 50}]})

(def ingredients-in-stock
  {:pistaccio-nuts 10
   :milk 1000
   :sugar 500})

(defn have-sufficient-quantity-in-stock?
  [{:keys [name quantity]}]
  (println name quantity)
  (>= (get ingredients-in-stock name)
      quantity))

(comment
  ;; what is destructuring?
 (defn foo [{:keys [bar]}]
   bar)

 (foo {})
 (foo {:bar 123123})
 )

(defn make-ice-cream [flavor]
  (let [recipe (get recipes flavor)]
    ;; [{:name :pistaccio-nuts, :quantity 20}
    ;;  {:name :milk, :quantity 100}
    ;;  {:name :sugar, :quantity 50}]
    (if (every? have-sufficient-quantity-in-stock? recipe)
      (let [🍦 {:taste :deligthful
                :color :green
                :image "🍦"}]
        🍦)
      "😭")))

(make-ice-cream :pistaccio)
(comment
  (let [result :abcdef]
    (if result
      then
      else))
  (if-let [result :bacde]
    then
    else)

  (defn extract-graph-from-image [image]
   (if-let [result (some-> image
                           convert-image-to-textual-description
                           textual-description->graph
                           store-graph-in-db)]
     {:status :ok
      :result result}
     {:status :error}))
  )

(some->> [1 2 3]
         (map inc) ;; [2 3 4]
         (filter (fn [x] (> x 5)))
         seq ;; nil, so some->> will not carry on, and just return nil instead
         println)


;; In Clojure, there is the notion of logical true and logical false values
;; a logical true value makes an if-test pass
;; the only logical false values are: false, nil
(if false
  :yes
  :no)
(if (or nil 12)
  :yes
  :no)

(or nil -1 12)
(and -1 12 (or false []))

(defn all-of-legal-age? [group-of-people]
  ;;(every? (fn [person] (>= (:age person) 18)) group-of-people)
  (let [underage-people (filter (fn [person] (< (:age person) 18)) group-of-people)]
    (if (not (empty? underage-people))
      :block
      :let-them-in)))

(all-of-legal-age? [{:age 18} {:age 20}])

(my-boolean +)
(my-boolean nil)
(my-boolean false)

(comment
 (make-ice-cream :pistaccio nil)
 )

(defn sell-ice-cream [stock flavor]
  )
