package com.shyun.mybottomnavigation.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.util.Log
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.shyun.mybottomnavigation.R


class MyMarkerView(context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {
    companion object {
        private const val TAG = "MyMarkerView"
    }
    private var tvContent: TextView

    init {
        tvContent = findViewById(R.id.test_marker_view)
    }

    override fun draw(canvas: Canvas?) {
        canvas!!.translate(-(width / 2).toFloat(), -height.toFloat() )
        super.draw(canvas)
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        tvContent.text = e?.y?.toInt().toString()
        super.refreshContent(e, highlight)
    }
}