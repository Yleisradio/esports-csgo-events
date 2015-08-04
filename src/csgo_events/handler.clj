(ns csgo_events.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [clojure.tools.logging :as log]
            [csgo_events.server :as server]
            [edn-config.core :refer [env]])
  (:gen-class))


(def get-port (:collector.port env))

(defn init [] (do
                (log/infof "Started CS:GO events collector in [%s] environment" (:env env))
                (server/start get-port)
                ))

(defn destroy [] (server/stop))

(defapi app
        (swagger-ui)
        (swagger-docs
          {:info {:title       "csgo-events"
                  :description "Ping api for csgo-events applications."}})
        (context* "/api" []
                  (GET* "/health" []
                        (ok {:status "OK"}))))
