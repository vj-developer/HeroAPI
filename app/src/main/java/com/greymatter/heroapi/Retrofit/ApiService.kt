package com.greymatter.heroapi.Retrofit

import com.greymatter.heroapi.Model.AllHeroResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    //ALL Heroes A-Z
    @GET("search/a")
    fun getAllHeroes(): Call<AllHeroResponse>
}