package com.k7.mealapp.data.model.api

import com.google.gson.annotations.SerializedName

data class Ingredient(

    @SerializedName("idIngredient") var idIngredient : String,
    @SerializedName("strIngredient") var ingredient : String,
    @SerializedName("strDescription") var description : String,
    @SerializedName("strType") var type : String

)