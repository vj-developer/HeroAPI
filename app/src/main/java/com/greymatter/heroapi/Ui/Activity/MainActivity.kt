package com.greymatter.heroapi.Ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.greymatter.heroapi.ViewModel.Factory.AllHeroModelFactory
import com.greymatter.heroapi.Model.AllHeroResponse
import com.greymatter.heroapi.Model.HeroResult
import com.greymatter.heroapi.R
import com.greymatter.heroapi.Ui.Adapter.HeroAdapter
import com.greymatter.heroapi.ViewModel.AllHeroViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var heroesList: MutableList<HeroResult>
    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_main.layoutManager = LinearLayoutManager(this@MainActivity)
        heroesList = mutableListOf<HeroResult>()
        adapter = HeroAdapter(this, heroesList)
        recycler_main.adapter = adapter

        val userViewModel = ViewModelProviders.of(this, AllHeroModelFactory(this)).get(AllHeroViewModel::class.java)
        userViewModel.getData().observe(this,object: Observer<AllHeroResponse> {
            override fun onChanged(t: AllHeroResponse?) {
                heroesList.clear()
                t?.let { heroesList.addAll(t.results) }
                adapter.notifyDataSetChanged()
            }

        })

    }
}