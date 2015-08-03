(defproject csgo_events "0.1.0-SNAPSHOT"
  :description "Esports csgo server event collector"
  :url "https://github.com/Yleisradio/esports-csgo-events"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-time "0.9.0"]
                 [metosin/compojure-api "0.22.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.slf4j/slf4j-api "1.7.10"]
                 [ch.qos.logback/logback-classic "1.1.3"]
                 [org.clojure/tools.trace "0.7.8"]
                 [clj-time "0.10.0"]
                 [edn-config "0.3"]]
  :ring {:handler csgo_events.handler/app
         :init    csgo_events.handler/init
         :destroy csgo_events.handler/destroy}
  :uberjar-name "server.jar"
  :license {:name "The MIT License (MIT)"
            :url  "http://opensource.org/licenses/MIT"}
  :profiles {:dev  {:dependencies   [[javax.servlet/servlet-api "2.5"]
                                     [cheshire "5.3.1"]
                                     [ring-mock "0.1.5"]]
                    :plugins        [[lein-ring "0.9.6"]]
                    :resource-paths ["config/dev" "resources"]}
             :test {:resource-paths ["config/test" "resources"]}
             :prod {:resource-paths ["config/prod" "resources"]}
             }
  :source-paths ["src"]
  :test-paths ["test"]
  :jvm-opts ["-Xmx1g"])
