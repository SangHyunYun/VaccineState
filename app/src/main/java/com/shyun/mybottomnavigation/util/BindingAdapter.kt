package com.shyun.mybottomnavigation.util

import android.graphics.Color
import android.util.Log
import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.shyun.mybottomnavigation.R
import com.shyun.mybottomnavigation.model.VaccineResponse
import com.shyun.mybottomnavigation.ui.custom.MyMarkerView


@BindingAdapter("bind:setVaccineData")
fun setVaccineData(chart: LineChart, dataList: List<VaccineResponse.Data>?) {
    val xValues = ArrayList<String>()
    val firstEntries = ArrayList<Entry>()
    val secondEntries = ArrayList<Entry>()
    Log.d("BindingAdapter", "setVaccineData: dataList : $dataList")
    if (!dataList.isNullOrEmpty()) {
        dataList.forEachIndexed { index, data ->
            run {
                firstEntries.add(Entry(index.toFloat(), data.totalFirstCnt.toFloat()))
                secondEntries.add(Entry(index.toFloat(), data.totalSecondCnt.toFloat()))
                xValues.add(data.sido)
            }
        }.let {
            val dataSets: ArrayList<ILineDataSet> = ArrayList()
            dataSets.add(LineDataSet(firstEntries, "1차 예방접종").apply {
                setColor(Color.BLACK)
                setCircleColor(Color.BLACK)
                axisDependency = YAxis.AxisDependency.LEFT
            })
            dataSets.add(LineDataSet(secondEntries, "2차 예방접종").apply {
                setColor(Color.RED)
                setCircleColor(Color.RED)
                axisDependency = YAxis.AxisDependency.LEFT
            })
            chart.apply {
                description.text =  dataList[0].baseDate.split(" ")[0]
                description.textSize = 12f
                description.isEnabled = true
                setPinchZoom(true)
                marker = MyMarkerView(chart.context, layoutResource = R.layout.marker_textview)
            }

            chart.xAxis.apply {
                granularity = 1f
                valueFormatter = object : ValueFormatter() {
                    override fun getAxisLabel(value: Float, axis: AxisBase): String {
                        return xValues.get(value.toInt())
                    }
                }
                setDrawGridLines(false)
                setLabelCount(xValues.size, true)
                labelRotationAngle = 270f
                axisMinimum = 0f
                axisMaximum = (xValues.size - 1).toFloat()

            }

            chart.axisLeft.apply {
                setDrawGridLines(false)
            }
            chart.axisRight.apply {
                setDrawGridLines(false)
                setDrawLabels(false)
                setDrawAxisLine(false)
            }
            val data = LineData(dataSets)
            chart.setData(data)
            chart.invalidate()
        }
    }
}


