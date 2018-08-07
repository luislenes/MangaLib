package com.android.luislenes.mangalib.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Manga::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = instance ?: Room.databaseBuilder(context,
                AppDatabase::class.java, "manga_library_db").build()
    }

    abstract fun mangaDao(): MangaDao
}