package com.greymatter.heroapi.Ui.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.greymatter.heroapi.Model.HeroResult
import com.greymatter.heroapi.R

class HeroAdapter (private val context: Context, private var list: MutableList<HeroResult>) : RecyclerView.Adapter<HeroAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.hero_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val heroResult = list.get(position)
        holder.name?.text = heroResult.name
        holder.id?.text = heroResult.id
        Glide.with(context).load(heroResult.image.url).placeholder(R.drawable.loading).into(holder.heroImage!!)
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view){

        var name: TextView? = null
        var id: TextView? = null
        var heroImage: ImageView? = null

        init {
            name = view.findViewById(R.id.hero_name)
            id = view.findViewById(R.id.txt_hero_id)
            heroImage = view.findViewById(R.id.hero_image)
        }

    }

}