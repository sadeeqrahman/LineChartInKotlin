package com.encoders.linechartinkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class MainActivity : AppCompatActivity() {
    lateinit var set1: LineDataSet
    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lineChart = findViewById(R.id.linechart)
        linechart()
    }


    fun linechart() {

        val xAxisValues: List<String> = ArrayList(
            listOf(
                "J",
                "F",
                "M",
                "A",
                "M",
                "J",
                "J",
                "A",
                "S",
                "O",
                "N",
                "D"
            )
        )


        val incomeEntries: ArrayList<Entry> = ArrayList()

        incomeEntries.add(Entry(1f, 0f))
        incomeEntries.add(Entry(2f, 0f))
        incomeEntries.add(Entry(3f, 0f))
        incomeEntries.add(Entry(4f, 0f))
        incomeEntries.add(Entry(5f, 50f))
        incomeEntries.add(Entry(6f, 0f))
        incomeEntries.add(Entry(7f, 20f))
        incomeEntries.add(Entry(8f, 0f))
        incomeEntries.add(Entry(9f, 0f))
        incomeEntries.add(Entry(10f, 0f))
        incomeEntries.add(Entry(11f, 0f))
        incomeEntries.add(Entry(12f, 0f))

        val dataSets: ArrayList<ILineDataSet> = ArrayList()


        set1 = LineDataSet(incomeEntries.subList(0,12), "income")
        dataSets.add(set1)
        set1.setCircleColor(resources.getColor(R.color.black))

        set1.mode = LineDataSet.Mode.HORIZONTAL_BEZIER
        set1.color = resources.getColor(R.color.purple_200)
        set1.lineWidth = 4f
        set1.setDrawFilled(true)
        set1.fillColor = resources.getColor(R.color.black)
        lineChart.animateXY(2000, 2000)
        lineChart.xAxis.setDrawGridLines(false)
        lineChart.axisRight.gridLineWidth = 1f
        lineChart.axisRight.enableGridDashedLine(20f, 20f, 20f)
        lineChart.axisRight.gridColor = R.color.black
        lineChart.axisLeft.setDrawGridLines(false)
        lineChart.description.isEnabled = false
        lineChart.legend.isEnabled = false
        lineChart.axisRight.setDrawLabels(false)
        set1.setDrawValues(false)
        lineChart.axisRight.setDrawAxisLine(false)
        lineChart.axisLeft.setDrawAxisLine(false)
        lineChart.xAxis.setDrawAxisLine(false)
        set1.setDrawCircles(true)
        lineChart.setBackgroundColor(Color.TRANSPARENT)
        val xAxis: XAxis = lineChart.xAxis
        xAxis.granularity = 1f
        xAxis.setCenterAxisLabels(true)
        xAxis.isEnabled = true
        xAxis.setDrawGridLines(false)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.labelCount = 8
        xAxis.textColor = R.color.teal_700

        lineChart.xAxis.valueFormatter = IndexAxisValueFormatter(xAxisValues)
        val data = LineData(dataSets)
        lineChart.data = data
        lineChart.data.setDrawValues(true)

    }




}