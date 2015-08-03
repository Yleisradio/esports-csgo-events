(ns csgo_events.collector
  (require [clj-time.format :as f]
           [edn-config.core :refer [env]])
  (:import (org.joda.time DateTime))
  (:gen-class))


(def get-path (:collector.events.folder env))

(def built-in-formatter (f/formatters :date-hour))

(defn getDate [time] (f/unparse built-in-formatter time))

(defn get-suffix [server] (str server "_" (getDate (DateTime.)) ".log"))

(defn write-file [server line]
  (with-open [w (clojure.java.io/writer (str get-path (get-suffix server)) :append true)]
    (.write w (str line))))

(defn collect [message]
  (write-file (get message :server) (get message :line))
  )
