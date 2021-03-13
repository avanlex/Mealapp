package com.k7.mealapp.model.api

import com.google.gson.annotations.SerializedName

data class CategoriesAPI(

    @SerializedName("categories") var categories : List<CategoryAPI>

)
