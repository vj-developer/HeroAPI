package com.greymatter.heroapi.ViewModel.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.greymatter.heroapi.ViewModel.AllHeroViewModel

class AllHeroModelFactory (private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllHeroViewModel(context) as T
    }

}