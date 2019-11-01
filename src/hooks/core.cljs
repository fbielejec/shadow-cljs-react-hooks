(ns hooks.core
  (:require [reagent.core :as r]
            [hooks.main :refer [app]]))

(goog-define environment "dev")

(defn dev-setup []
  (when (= "dev" environment)
    (enable-console-print!)))

(defn rerender []
  (js/console.log "rerender")
  (r/render [app] (.getElementById js/document "app")))

(defn stop []
  (js/console.log "stop"))

(defn ^:export init []
  (dev-setup)
  (rerender))
