package com.miftarisimel.buckneer.ui.common

import android.text.format.DateFormat
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.ocpsoft.prettytime.PrettyTime
import java.util.*

@BindingAdapter("timestamp")
fun loadTime(view: TextView, timestamp: String) {
//    val calendar = Calendar.getInstance(Locale.ENGLISH)
//    calendar.timeInMillis = timestamp.toInt() * 1000L
//    val date = DateFormat.format("dd-MM-yyyy",calendar).toString()
//    view.text = date

    val cal = Calendar.getInstance(Locale.ENGLISH)
    cal.setTimeInMillis(timestamp.toLong())
//    val date =
//        DateFormat.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", cal).toString()

    val prettyTime = PrettyTime(Locale.getDefault())
    val ago = prettyTime.format(cal)
    view.text = ago
}