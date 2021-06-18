package com.greymatter.heroapi.ViewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greymatter.heroapi.Model.AllHeroResponse
import com.greymatter.heroapi.Repository.AllHeroRepository
import com.greymatter.heroapi.Utils.Utility

class AllHeroViewModel (context: Context) : ViewModel() {
    private var listData = MutableLiveData<AllHeroResponse>()

    init{
        val allHeroRepository : AllHeroRepository by lazy {
            AllHeroRepository
        }
        if(Utility.isInternetAvailable(context)) {
            listData = allHeroRepository.getMutableLiveData(context)
        }
    }

    fun getData() : MutableLiveData<AllHeroResponse>{
        return listData
    }
}