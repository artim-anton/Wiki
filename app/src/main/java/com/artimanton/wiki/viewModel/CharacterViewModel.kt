package com.artimanton.wiki.viewModel

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.artimanton.wiki.model.Character


class CharacterViewModel: ViewModel() {
    private var repository: CharacterRepository? = null
    private var allCharacter: LiveData<List<Character>>? = null
    fun CharacterViewModel() {
        repository = CharacterRepository()
        allCharacter = repository!!.getAllNotes()
    }

    fun getAllNotes(): LiveData<List<Character>>? {
        return allCharacter
    }


}