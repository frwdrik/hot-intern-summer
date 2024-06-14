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
  {:pistaccio-nuts 100
   :milk 1000
   :sugar 500})

(defn have-sufficient-quantity-in-stock? [ingredient-with-name-and-quantity]
  (let [ingredient-name (:name ingredient-with-name-and-quantity)
        ingredient-quantity (:quantity ingredient-with-name-and-quantity)]
    (>= (get ingredients-in-stock ingredient-name)
        ingredient-quantity)))

(defn have-sufficient-quantity-in-stock?-v2
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

(defn make-ice-cream [flavor ingredients]
  (let [recipe (get recipes flavor)]
    ;; [{:name :pistaccio-nuts, :quantity 20}
    ;;  {:name :milk, :quantity 100}
    ;;  {:name :sugar, :quantity 50}]
    (every? have-sufficient-quantity-in-stock?-v2 recipe)))

(comment
 (make-ice-cream :pistaccio nil)
 )

(defn sell-ice-cream [stock flavor]
  )
