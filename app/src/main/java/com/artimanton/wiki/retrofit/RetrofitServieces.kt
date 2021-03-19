package com.artimanton.wiki.retrofit

import com.artimanton.wiki.model.Character
import retrofit2.Call
import retrofit2.http.GET

class RetrofitServieces {
    interface RetrofitServices {
        @GET("character")
        fun getCharacterList(): Call<MutableList<Character>>
    }
}