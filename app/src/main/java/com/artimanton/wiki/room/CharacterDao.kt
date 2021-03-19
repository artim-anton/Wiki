package com.artimanton.wiki.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.artimanton.wiki.model.Character


@Dao
interface CharacterDao {
    @get:Query("SELECT * FROM character")
    val all: List<Any?>?

    @Query("SELECT * FROM character WHERE id = :id")
    fun getById(id: Long): Character?

    @Insert
    fun insert(character: Character?)

    @Update
    fun update(character: Character?)

    @Delete
    fun delete(character: Character?)

    @Query("SELECT * FROM character ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Character>>?
}