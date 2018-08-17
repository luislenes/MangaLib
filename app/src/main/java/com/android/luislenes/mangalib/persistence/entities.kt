package com.android.luislenes.mangalib.persistence

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "manga")
data class Manga(
        @PrimaryKey(autoGenerate = true) val id: Int?,
        val title: String = "",
        val description: String = "",
        @ColumnInfo(name = "url_image") val urlImage: String = "",
        val rate: String = "")