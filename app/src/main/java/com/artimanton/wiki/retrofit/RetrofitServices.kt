package com.artimanton.wiki.retrofit

import com.artimanton.wiki.model.Character
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
        @GET("character/2")
        fun getCharacterList(): Call<Character>
}