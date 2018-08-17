package com.android.luislenes.mangalib.ui.newmanga

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.android.luislenes.mangalib.R
import com.android.luislenes.mangalib.databinding.ActivityNewMangaBinding
import com.android.luislenes.mangalib.util.afterTextChanged
import kotlinx.android.synthetic.main.activity_new_manga.*
import org.jetbrains.anko.longToast

class NewMangaActivity : AppCompatActivity() {

    lateinit var binding : ActivityNewMangaBinding
    lateinit var vm: NewMangaVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewMangaBinding.inflate(layoutInflater)
        binding.setLifecycleOwner(this)
        setContentView(binding.root)

        setUpVM()
        setUpTextWatchers()

        setTitle(R.string.new_manga_header)

        btnAddManga.setOnClickListener {
            if (vm.addManga()) longToast(R.string.new_manga_success) else longToast(R.string.uncompleted_form)
            finish()
        }
    }

    fun setUpVM() {
        vm = ViewModelProviders.of(this, NewMangaVMFactory(application)).get(NewMangaVM::class.java)
        with(vm) {
            title.observe(this@NewMangaActivity, Observer { manga = manga.copy(title = it!!) })
            description.observe(this@NewMangaActivity, Observer { manga = manga.copy(description = it!!) })
            urlImage.observe(this@NewMangaActivity, Observer { manga = manga.copy(urlImage = it!!) })
            rate.observe(this@NewMangaActivity, Observer { manga = manga.copy(rate = it!!) })
        }
    }

    fun setUpTextWatchers() {
        binding.etTitle.afterTextChanged { vm.title.postValue(it) }
        binding.etDesc.afterTextChanged { vm.description.postValue(it) }
        binding.etImage.afterTextChanged { vm.urlImage.postValue(it) }
        binding.etRate.afterTextChanged { vm.rate.postValue(it) }
    }
}
