package com.k7.mealapp.model.api

import com.google.gson.annotations.SerializedName

data class IngredientAPI(

    @SerializedName("idIngredient") var idIngredient : Int?,
    @SerializedName("strIngredient") var ingredient : String?,
    @SerializedName("strDescription") var description : String?,
    @SerializedName("strType") var type : String?

)