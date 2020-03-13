package com.miftarisimel.buckneer.models

import com.google.firebase.database.Exclude
import com.google.firebase.database.ServerValue
import java.text.SimpleDateFormat
import java.util.*

data class Project(
    val uid: String = "",
    val name: String = "",
    val title: String = "",
    val description: String = "",
    val timestamp: Any = ServerValue.TIMESTAMP,
    val category: Category = Category.OTHER,
    val bids: String = "",
    @get:Exclude val id: String = ""
) {
    fun timestampDate(): Date = Date(timestamp as Long)
    fun convertToDate(): String {
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val format = date.format(timestamp.toString())
        return format
    }
}