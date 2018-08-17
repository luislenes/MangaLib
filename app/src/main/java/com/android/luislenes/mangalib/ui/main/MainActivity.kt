package com.android.luislenes.mangalib.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.android.luislenes.mangalib.R
import com.android.luislenes.mangalib.ui.newmanga.NewMangaActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainVM
    private lateinit var adapter: MangaListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewConfig()
        setUpVM()
        setButtonClickEvents()
    }

    private fun setButtonClickEvents() {
        btnAddItem.setOnClickListener {
//            vm.insert(Manga(null,
//                    getString(R.string.test_title),
//                    getString(R.string.test_desc),
//                    getString(R.string.test_url_image),
//                    getString(R.string.test_rate)))
            startActivity(Intent(this, NewMangaActivity::class.java))
        }

        btnDeleteAll.setOnClickListener { vm.deleleAll() }
    }

    private fun setUpVM() {
        vm = ViewModelProviders.of(this, MainVMFactory(application)).get(MainVM::class.java)
        vm.getAllMangas().observe(this, Observer { adapter.mangaList = it })
    }

    private fun recyclerViewConfig() {
        adapter = MangaListAdapter(this)
        recyclerManga.adapter = adapter
        recyclerManga.layoutManager = LinearLayoutManager(this)
    }
}
