package com.android.luislenes.mangalib.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.android.luislenes.mangalib.R
import com.android.luislenes.mangalib.persistence.Manga
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MangaListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewConfig()
        viewModelConfig()
        setButtonClickEvents()
    }

    private fun setButtonClickEvents() {
        btnAddItem.setOnClickListener {
            viewModel.insert(Manga(null,
                    getString(R.string.test_title),
                    getString(R.string.test_desc),
                    getString(R.string.test_url_image),
                    getString(R.string.test_rate)))
        }

        btnDeleteAll.setOnClickListener {
            viewModel.deleleAll()
        }
    }

    private fun viewModelConfig() {
        viewModel = ViewModelProviders.of(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        viewModel.getAllMangas().observe(this, Observer {
            adapter.mangaList = it
        })
    }

    private fun recyclerViewConfig() {
        adapter = MangaListAdapter(this)
        recyclerManga.adapter = adapter
        recyclerManga.layoutManager = LinearLayoutManager(this)
    }
}
