package com.k7.mealapp.data.model.api

import com.google.gson.annotations.SerializedName

data class IngredientsAPI(

    @SerializedName("meals") var ingredients : List<IngredientAPI>

)
