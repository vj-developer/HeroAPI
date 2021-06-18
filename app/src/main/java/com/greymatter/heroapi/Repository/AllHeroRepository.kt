package com.greymatter.heroapi.Repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.greymatter.heroapi.Model.AllHeroResponse
import com.greymatter.heroapi.Retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object AllHeroRepository {

    fun getMutableLiveData(context: Context) : MutableLiveData<AllHeroResponse> {
        val mutableLiveData = MutableLiveData<AllHeroResponse>()
        //context.showProgressBar()

        ApiClient.apiService.getAllHeroes().enqueue(object : Callback<AllHeroResponse> {
            override fun onFailure(call: Call<AllHeroResponse>, t: Throwable) {
                //hideProgressBar()
                Log.e("error", t.message.toString())
            }

            override fun onResponse(
                call: Call<AllHeroResponse>,
                response: Response<AllHeroResponse>
            ) {
                //hideProgressBar()
                val heroesResponse = response.body()
                heroesResponse?.let { mutableLiveData.value = it as AllHeroResponse }
            }

        })

        return mutableLiveData
    }
}