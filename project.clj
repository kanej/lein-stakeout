(defproject lein-stakeout "0.1.0"
  :description "Executes a shell command when a file it is monitoring is modified."
  :dependencies [[org.clojure/clojure "1.1.0"]
                 [org.clojure/clojure-contrib "1.1.0"]
                 [clj-glob "0.1.0"]]
  :dev-dependencies [[lein-clojars "0.5.0"]]
  :main stakeout.core)
