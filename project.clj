(defproject com.topmonks/qlkit-re-charts "0.3.0-SNAPSHOT"
  :description "qlkit wrapper for re-charts"
  :url "https://github.com/topmonks/qlkit-re-charts"

  :license
  {:name "Eclipse Public License"
   :url "http://www.eclipse.org/legal/epl-v10.html"}

  :repositories [["clojars" {:sign-releases false}]]

  :jvm-opts ^:replace ["-Xms512m" "-Xmx512m" "-server"]

  :dependencies
  [[org.clojure/clojure "1.9.0" :scope "provided"]
   [org.clojure/clojurescript "1.9.946" :scope "provided"]
   [cljsjs/recharts "1.0.0-beta.10-0"]
   [qlkit "0.3.0-SNAPSHOT" :scope "provided"]]

  :jar-exclusions
  [#".DS_Store" #"dev" #"devcards" #"test" #"index.html" #"main" #"public"]

  :clean-targets ^{:protect false} ["resources/out"]

  :deploy-repositories
  [["releases" {:sign-releases false :url "https://clojars.org/repo"}]
   ["snapshots" {:sign-releases false :url "https://clojars.org/repo"}]]

  :release-tasks
  [["vcs" "assert-committed"]
   ["change" "version" "leiningen.release/bump-version" "release"]
   ["vcs" "commit"]
   ["vcs" "tag" "v" "--no-sign"]
   ["deploy"]
   ["change" "version" "leiningen.release/bump-version"]
   ["vcs" "commit"]
   ["vcs" "push"]]

  :profiles
  {:debug {:debug true}
   :dev
   {:dependencies
    [[binaryage/devtools "0.9.9"]]}})
