package com.artimanton.wiki.retrofit

import com.artimanton.wiki.model.AllCharacters
import com.artimanton.wiki.model.Character
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
        @GET("character/2")
        fun getCharacter(): Call<Character>
        @GET("character")
        fun getCharacterList(): Call<AllCharacters>
}