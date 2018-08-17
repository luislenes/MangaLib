package com.android.luislenes.mangalib.persistence

import android.app.Application
import android.arch.lifecycle.LiveData
import org.jetbrains.anko.doAsync

class MangaRepository private constructor(app: Application) {

    companion object {
        private var instance: MangaRepository? = null

        fun getInstance(app: Application): MangaRepository = instance ?: MangaRepository(app)
    }

    private var mangaDao: MangaDao = AppDatabase.getInstance(app).mangaDao()

    fun getAllMangas() = mangaDao.getAll()

    fun insert(manga: Manga) {
        doAsync {
            mangaDao.insert(manga)
        }
    }

    fun deleleAll() {
        doAsync {
            mangaDao.deleteAll()
        }
    }
}