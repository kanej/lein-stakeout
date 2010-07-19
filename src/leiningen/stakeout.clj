(ns
  #^{:doc "Execute the shell command whenever the given files change."} 
  leiningen.stakeout
  (:use [stakeout.core :only [stakeout-rec get-files]]))

(defn stakeout [project path-glob shell-command]
  (do
    (println "Watching files:")
    (apply print (map #(str (.toString %)) (get-files path-glob)))
    (println "")
    (stakeout-rec path-glob shell-command)))
