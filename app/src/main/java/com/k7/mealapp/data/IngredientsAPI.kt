package com.k7.mealapp.data

import com.google.gson.annotations.SerializedName

data class IngredientsAPI(

    @SerializedName("meals") var ingredients : List<Ingredient>

)
