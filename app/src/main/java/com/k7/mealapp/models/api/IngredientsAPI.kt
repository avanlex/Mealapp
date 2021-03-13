package com.k7.mealapp.model.api

import com.google.gson.annotations.SerializedName

data class IngredientsAPI(

    @SerializedName("meals") var ingredients : List<IngredientAPI>

)
