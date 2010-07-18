(ns stakeout.core
  (:use [clojure.contrib.duck-streams])
  (:use [clojure.contrib.shell-out])
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
  "Gets the files in a given directory and its subdirectories."
  [dir-path]
  (filter #(not (.isDirectory %)) (file-seq (file-str dir-path))))

(defn files-modified-in-dir? 
  "Determine whether any files have been modified in the 
   given directory (or subdirectories) in the last check period."
  [dir-path]
  (some recently-modified? (get-files dir-path)))

(defn run-command
  "Execute a shell command and print the result."
  [command]
  (println (sh "bash" :in command)))

(defn stakeout
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
    (stakeout (first args) (second args))))
