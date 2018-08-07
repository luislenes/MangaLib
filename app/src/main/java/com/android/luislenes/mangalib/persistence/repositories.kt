package com.android.luislenes.mangalib.persistence

import android.app.Application
import android.arch.lifecycle.LiveData
import org.jetbrains.anko.doAsync

class MangaRepository(app: Application) {

    private val mangaDao: MangaDao = AppDatabase.getInstance(app).mangaDao()
    private var mangas: LiveData<List<Manga>>

    init {
        mangas = mangaDao.getAll()
    }

    fun getAllMangas() = mangas

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