package com.artimanton.wiki.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import com.artimanton.wiki.model.Character
import com.artimanton.wiki.room.CharacterDao
import com.artimanton.wiki.room.RoomDB


class CharacterRepository {
    private var characterDao: CharacterDao? = null
    private var allCharacter: LiveData<List<Character>>? = null

    fun CharacterRepository(application: Application?) {
        val database: RoomDB = application?.let { RoomDB.getInstance(it) }!!
        characterDao = database.characterDao()
        allCharacter = characterDao!!.getAllNotes()
    }

    fun getAllNotes(): LiveData<List<Character>>? {
        return allCharacter
    }
}