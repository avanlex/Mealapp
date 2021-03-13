package com.k7.mealapp.data

import com.google.gson.annotations.SerializedName

data class SearchMainIngredientAndAreaAndCategoryAPI(

    @SerializedName("meals") var mealsFromFindFindMainIngredient : List<MealForFindMainIngredientAndAreaAndCategory>

)
