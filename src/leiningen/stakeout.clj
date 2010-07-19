(ns
  #^{:doc "Execute a command whenever the given files change."} 
  leiningen.stakeout
  (:use [stakeout.core :only [stakeout-rec]]))

(defn stakeout [project path-glob shell-command]
  (do
    (println "Watching directory ...")
    (stakeout-rec path-glob shell-command)))
