(ns qlkit-re-charts.core
  (:require
    [cljsjs.recharts]
    [goog.object :as object]
    [qlkit.core :as ql]))

(defn- recharts [key]
  (or (object/get js/Recharts (name key))
      (throw (str "Unknown re-charts component " (name key)))))

(def re-charts-components
  (merge
    ;; containers
    {:layer (recharts :Layer)
     :surface (recharts :Surface)}
    ;; components
    {:cell (recharts :Cell)
     :label (recharts :Label)
     :label-list (recharts :LabelList)
     :legend (recharts :Legend)
     :responsive-container (recharts :ResponsiveContainer)
     :text (recharts :Text)
     :tooltip (recharts :Tooltip)}
    ;; shapes
    {:cross (recharts :Cross)
     :curve (recharts :Curve)
     :dot (recharts :Dot)
     :polygon (recharts :Polygon)
     :rectangle (recharts :Rectangle)
     :sector (recharts :Sector)
     :symbols (recharts :Symbols)}
    ;; cartesian
    {:area (recharts :Area)
     :bar (recharts :Bar)
     :brush (recharts :Brush)
     :cartesian-axis (recharts :CartesianAxis)
     :cartesian-grid (recharts :CartesianGrid)
     :error-bar (recharts :ErrorBar)
     :line (recharts :Line)
     :reference-line (recharts :ReferenceLine)
     :reference-dot (recharts :ReferenceDot)
     :reference-area (recharts :ReferenceArea)
     :scatter (recharts :Scatter)
     :x-axis (recharts :XAxis)
     :y-axis (recharts :YAxis)
     :z-axis (recharts :ZAxis)}
    ;; polar
    {:pie (recharts :Pie)
     :polar-angle-axis (recharts :PolarAngleAxis)
     :polar-grid (recharts :PolarGrid)
     :polar-radius-axis (recharts :PolarRadiusAxis)
     :radar (recharts :Radar)
     :radial-bar (recharts :RadialBar)}
    ;; charts
    {:area-chart (recharts :AreaChart)
     :bar-chart (recharts :BarChart)
     :composed-chart (recharts :ComposedChart)
     :line-chart (recharts :LineChart)
     :pie-chart (recharts :PieChart)
     :radar-chart (recharts :RadarChart)
     :radial-bar-chart (recharts :RadialBarChart)
     :sankey (recharts :Sankey)
     :scatter-chart (recharts :ScatterChart)
     :treemap (recharts :Treemap)}))

(defn enable-re-charts! []
  (doseq [[k v] re-charts-components]
    (ql/register-component k v)))

