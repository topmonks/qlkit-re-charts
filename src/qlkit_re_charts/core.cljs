(ns qlkit-re-charts.core
  (:require
    [recharts]
    [goog.object :as object]
    [qlkit.core :as ql]))

(def ^:private containers
  {:layer recharts/Layer
   :surface recharts/Surface})

(def ^:private components
  {:cell recharts/Cell
   :funnel recharts/Funnel
   :label recharts/Label
   :label-list recharts/LabelList
   :legend recharts/Legend
   :responsive-container recharts/ResponsiveContainer
   :text recharts/Text
   :tooltip recharts/Tooltip})

(def ^:private shapes
  {:cross recharts/Cross
   :curve recharts/Curve
   :dot recharts/Dot
   :polygon recharts/Polygon
   :rectangle recharts/Rectangle
   :sector recharts/Sector
   :symbols recharts/Symbols
   :trapezoid recharts/Trapezoid})

(def ^:private cartesian
  {:area recharts/Area
   :bar recharts/Bar
   :brush recharts/Brush
   :cartesian-axis recharts/CartesianAxis
   :cartesian-grid recharts/CartesianGrid
   :error-bar recharts/ErrorBar
   :line recharts/Line
   :reference-line recharts/ReferenceLine
   :reference-dot recharts/ReferenceDot
   :reference-area recharts/ReferenceArea
   :scatter recharts/Scatter
   :x-axis recharts/XAxis
   :y-axis recharts/YAxis
   :z-axis recharts/ZAxis})

(def ^:private polar
  {:pie recharts/Pie
   :polar-angle-axis recharts/PolarAngleAxis
   :polar-grid recharts/PolarGrid
   :polar-radius-axis recharts/PolarRadiusAxis
   :radar recharts/Radar
   :radial-bar recharts/RadialBar})

(def ^:private charts
  {:area-chart recharts/AreaChart
   :bar-chart recharts/BarChart
   :composed-chart recharts/ComposedChart
   :funnel-chart recharts/FunnelChart
   :line-chart recharts/LineChart
   :pie-chart recharts/PieChart
   :radar-chart recharts/RadarChart
   :radial-bar-chart recharts/RadialBarChart
   :sankey recharts/Sankey
   :scatter-chart recharts/ScatterChart
   :treemap recharts/Treemap})

(def re-charts-components
  (merge
    containers
    components
    shapes
    cartesian
    polar
    charts))

(defn enable-re-charts! []
  (doseq [[k v] re-charts-components]
    (ql/register-component k v)))

