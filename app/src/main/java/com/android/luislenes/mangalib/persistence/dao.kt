package com.android.luislenes.mangalib.persistence

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface BaseDao<in T> {
    @Insert
    fun insert(t: T): Long
    @Update
    fun update(t: T)
    @Delete
    fun delete(t: T)
}

@Dao
interface MangaDao : BaseDao<Manga> {

    @Query("select * from manga")
    fun getAll(): LiveData<List<Manga>>

    @Query("select * from manga m where m.id = :id")
    fun findById(id: Long): LiveData<Manga>

    @Query("select * from manga m where m.title like '%' + :title + '%'")
    fun findByName(title: String): LiveData<List<Manga>>

    @Query("delete from manga")
    fun deleteAll()
}