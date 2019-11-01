(ns hooks.main
  (:require [reagent.core :as r]
            ["react" :as react]))

;; react component
;; (Can't use ratoms here)
(defn- app-element []
  (let [[count setCount] (react/useState 0)]
    (r/as-element
     [:div {:style {:display :flex
                    :flex-direction :column}}
      "REACT HOOKS DEMO"
      [:span [:code "click-count"] " has value: "  count ". "]
      [:input {:type "button" :value "Click me!"
               :on-click (fn [e]
                           (prn "click!" count)
                           (setCount (inc count)))}]])))

;; Reagent component
(defn app []
  [:div
   ;; Note :> to use a function as React component
   [:> app-element]])
