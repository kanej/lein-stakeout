(ns stakeout.core-test
  (:use [stakeout.core] :reload-all)
  (:use [clojure.test])
  (:use [clojure.contrib.duck-streams]))

;; Helper Functions
(defn touch [file-path]
  (.setLastModified (file-str file-path) (+ 1000 (.getTime (java.util.Date.)))))

(defn setup-new-temp-file [file-name]
  (do 
    (let [new-temp-file (file-str file-name)]
      (if (.exists new-temp-file) (.delete new-temp-file)) 
    (spit "temp.clj" "delete - this is a test.")
    new-temp-file)))

;; Recently Modified?
(deftest a-file-that-has-been-altered-counts-as-recently-modified
  (touch "./test/stakeout/dummy/readme.md")
  (is (recently-modified? (file-str "./test/stakeout/dummy/readme.md"))))

(deftest a-new-file-counts-as-recently-modified
  (let [newfile (setup-new-temp-file "temp.clj")]
    (is (recently-modified? newfile))
    (.delete newfile)))

(deftest nonexistant-files-do-not-count-as-modified
  (is (not (recently-modified? (file-str "nonexistant.clj")))))

;; Get files
(deftest can-retrieve-files-in-folder
  (let [files (get-files "./test/stakeout/dummy")]
    (is (= 2 (count files)))
    (is (= "./test/stakeout/dummy/example.clj" (.toString (first files))))
    (is (= "./test/stakeout/dummy/readme.md" (.toString (second files))))))

(deftest can-retrieve-files-in-subfolders
  (let [files (get-files "./test/stakeout/subfolderdummy")]
    (is (= 4 (count files)))))

;; Files modified in directory?
(deftest can-detemine-whether-a-dir-contains-recently-modified-files
  (touch "./test/stakeout/subfolderdummy/sub1/bye.clj")
    (is (files-modified-in-dir? "./test/stakeout/subfolderdummy/sub1")))

(deftest can-determine-whether-a-dir-does-not-contain-recently-modified-files
  (is (not (files-modified-in-dir? "./test/stakeout/subfolderdummy/sub2"))))
