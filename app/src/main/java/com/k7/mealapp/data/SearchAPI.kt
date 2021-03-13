package com.k7.mealapp.data


import com.google.gson.annotations.SerializedName


data class SearchAPI (


    @SerializedName("meals") var meals : List<Meal>

)

