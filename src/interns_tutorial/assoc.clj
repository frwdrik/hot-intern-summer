(ns interns-tutorial.assoc)

;; associate means to form a link between

(get {{} [{}]} {})

(defn query-one! [email]
  {:email email
   :age (rand-int 50)})

(defn add-age-of-user [{:keys [email age] :as user}]
  (let [age (-> (query-one! [:= :email email])
                :age)]
    (assoc user :age age)))

(add-age-of-user {:email "foo@bar.com"
                  :name "Foo Bar"
                  :age 90})

(let [user {:name "foo"
            :address {:street-name
                      "Boulevard of Broken Dreams"
                      :house-number 911}}]
  (assoc user :name "new name"))
