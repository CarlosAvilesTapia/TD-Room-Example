package com.example.roomexample.data.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Le indicamos a ROOM que esta data class va a ser una tabla en la BD
@Entity(tableName = "task_table")
data class Task(
    val task: String,
    @ColumnInfo(name = "creation_date") val creationDate: String,
    @ColumnInfo(name = "finish_date") val finishDate: String
) {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Long = 0
}