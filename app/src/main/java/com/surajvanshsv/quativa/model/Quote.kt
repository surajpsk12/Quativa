package com.surajvanshsv.quativa.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes_table")
data class Quote(
    val author: String,
    val body: String,
    @PrimaryKey
    val id: Int
)