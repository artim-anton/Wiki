package com.artimanton.wiki.retrofit


object Common {
    private val BASE_URL = "https://rickandmortyapi.com/api/"
    val retrofitService: RetrofitServieces.RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServieces.RetrofitServices::class.java)
}