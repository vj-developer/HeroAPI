package com.greymatter.heroapi.Model

import com.google.gson.annotations.SerializedName

class AllHeroResponse (
    val response: String,
    @SerializedName ("results-for")
    val resultsFor: String,
    val results: List<HeroResult>
    )
