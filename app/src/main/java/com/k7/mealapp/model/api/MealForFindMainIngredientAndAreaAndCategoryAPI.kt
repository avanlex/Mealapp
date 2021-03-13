package com.k7.mealapp.model.api

import com.google.gson.annotations.SerializedName

data class MealForFindMainIngredientAndAreaAndCategoryAPI (

    @SerializedName("strMeal") var meal : String?,
    @SerializedName("strMealThumb") var mealThumb : String?,
    @SerializedName("idMeal") var idMeal : Int?

)