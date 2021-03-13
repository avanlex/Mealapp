package com.k7.mealapp.model.api


import com.google.gson.annotations.SerializedName


data class SearchAPI (

    @SerializedName("meals") var meals : List<MealAPI>

)

