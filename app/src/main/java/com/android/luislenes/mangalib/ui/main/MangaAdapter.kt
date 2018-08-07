package com.android.luislenes.mangalib.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.luislenes.mangalib.BR
import com.android.luislenes.mangalib.databinding.MangaItemBinding
import com.android.luislenes.mangalib.persistence.Manga
import com.bumptech.glide.Glide

class MangaListAdapter(private val context: Context) : RecyclerView.Adapter<MangaViewHolder>() {

    var mangaList: List<Manga>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val binding = MangaItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false)
        return MangaViewHolder(binding)
    }

    override fun getItemCount(): Int = mangaList?.size ?: 0

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        if (mangaList != null) {
            holder.bind(context, mangaList!![position])
        }
    }
}

class MangaViewHolder(val binding: MangaItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(context: Context, mangaItem: Manga) {
        Glide.with(context).load(mangaItem.urlImage).into(binding.mangaPicture)
        binding.setVariable(BR.manga, mangaItem)
        binding.executePendingBindings()
    }
}