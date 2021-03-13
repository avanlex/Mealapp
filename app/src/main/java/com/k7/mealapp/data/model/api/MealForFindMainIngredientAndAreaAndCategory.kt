package com.k7.mealapp.data.model.api

import com.google.gson.annotations.SerializedName

data class MealForFindMainIngredientAndAreaAndCategory (

    @SerializedName("strMeal") var meal : String,
    @SerializedName("strMealThumb") var mealThumb : String,
    @SerializedName("idMeal") var idMeal : String

)