package com.android.luislenes.mangalib.ui.newmanga

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.text.TextUtils
import com.android.luislenes.mangalib.persistence.Manga
import com.android.luislenes.mangalib.persistence.MangaRepository

class NewMangaVM(app : Application) : AndroidViewModel(app) {

    val repository = MangaRepository.getInstance(app)

    var manga = Manga(null)

    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val urlImage = MutableLiveData<String>()
    val rate = MutableLiveData<String>()

    fun addManga() : Boolean {
        return if (TextUtils.isEmpty(manga.title) || TextUtils.isEmpty(manga.description) ||
                TextUtils.isEmpty(manga.urlImage) || TextUtils.isEmpty(manga.rate)) {
            false
        } else {
            repository.insert(manga)
            true
        }
    }
}

class NewMangaVMFactory(private val app: Application) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewMangaVM(app) as T
    }
}