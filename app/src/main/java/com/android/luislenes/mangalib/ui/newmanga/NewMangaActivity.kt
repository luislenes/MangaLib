package com.android.luislenes.mangalib.ui.newmanga

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.luislenes.mangalib.R
import kotlinx.android.synthetic.main.activity_new_manga.*

class NewMangaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_manga)

        setTitle(R.string.new_manga_header)

        btnAddManga.setOnClickListener {
            val intent = Intent()
            intent.putExtra("title", tvTitle.text)
            intent.putExtra("description", tvDesc.text)
            intent.putExtra("urlImage", tvImage.text)
            intent.putExtra("rate", tvRate.text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
