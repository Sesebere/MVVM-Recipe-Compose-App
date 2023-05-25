package com.example.mvvmrecipecomposeapp.network.response

import com.example.mvvmrecipecomposeapp.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDto>,
)