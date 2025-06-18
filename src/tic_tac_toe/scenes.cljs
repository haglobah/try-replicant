(ns tic-tac-toe.scenes
  (:require
   [portfolio.replicant :refer-macros [defscene]]
   [portfolio.ui :as portfolio]
   [tic-tac-toe.ui :as ui]))

(defscene empty-cell
  (ui/render-cell {}))

(defscene cell-with-x
  (ui/render-cell
   {:content ui/mark-x}))

(defn main []
  (portfolio/start!
   {:config
    {:css-paths ["/styles.css"]
     :viewport/defaults
     {:background/background-color "#fdeddd"}}}))

