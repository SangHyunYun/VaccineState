package com.shyun.mycorona.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtil {

    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        @JvmStatic
        fun getCurrentTime(): String {
            val current = LocalDateTime.now()
            val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val formatted = current.format(dateFormat)
            return "$formatted 00:00:00"
        }
    }
}