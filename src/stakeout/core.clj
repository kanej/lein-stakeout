(ns stakeout.core
  (:use [clojure.contrib.duck-streams])
  (:use [clojure.contrib.shell-out])
  (:use [org.satta.glob])
  (:gen-class))

(def
  #^{:doc "The period stakeout waits between checks 
           for modifications (milliseconds)."}
  *check-period* 1000)

(defn recently-modified? 
  "Determine whether a file has been modified within the last check period."
  [file]
  (when (.exists file)
    (> (.lastModified file) (- (.getTime (java.util.Date.)) *check-period*))))

(defn get-files
  "Gets files based on a given glob"
  [glob-paths-as-string]
  (let [glob-paths (filter #(not (= "" %)) (.split glob-paths-as-string " "))]
    (apply concat (map #(glob %) glob-paths))))

(defn files-modified-in-dir? 
  "Determine whether any files have been modified in the 
   given directory (or subdirectories) in the last check period."
  [dir-path]
  (some recently-modified? (get-files dir-path)))

(defn run-command
  "Execute a shell command and print the result."
  [command]
  (println (sh "bash" :in command)))

(defn stakeout-rec
  "Continously check whether files have been
   modified and execute the given command if they have."
  [dir-path command]
  (do 
    (Thread/sleep *check-period*)
    (if (files-modified-in-dir? dir-path) (run-command command))
    (recur dir-path command)))

(defn -main [& args]
  (do
    (println "Watching directory ...")
    (stakeout-rec (first args) (second args))))
