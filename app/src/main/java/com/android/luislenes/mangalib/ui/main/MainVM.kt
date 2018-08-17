package com.android.luislenes.mangalib.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.android.luislenes.mangalib.persistence.Manga
import com.android.luislenes.mangalib.persistence.MangaRepository

class MainVM(app: Application) : AndroidViewModel(app) {

    private val repository = MangaRepository.getInstance(app)
    private var mangas: LiveData<List<Manga>>

    init {
        mangas = repository.getAllMangas()
    }

    fun getAllMangas() = mangas

    fun insert(manga: Manga) = repository.insert(manga)

    fun deleleAll() = repository.deleleAll()
}

class MainVMFactory(private val app: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainVM(app) as T
    }
}