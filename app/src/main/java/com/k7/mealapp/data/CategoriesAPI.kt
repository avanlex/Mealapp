package com.k7.mealapp.data

import com.google.gson.annotations.SerializedName

data class CategoriesAPI(

    @SerializedName("categories") var categories : List<Categories>

)
