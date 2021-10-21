package com.fr1x3.foodjournal.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food(
    @PrimaryKey(autoGenerate = true)  val id : Int = 0,
    @ColumnInfo val description : String?,
    @ColumnInfo val category :String,
    @ColumnInfo( name = "hash_tag") val hashtag :  String?
)
