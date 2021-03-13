package com.k7.mealapp.model.api

import com.google.gson.annotations.SerializedName

data class CategoryAPI (

    @SerializedName("idCategory") var idCategory : Int,
    @SerializedName("strCategory") var category : String?,
    @SerializedName("strCategoryThumb") var categoryThumb : String?,
    @SerializedName("strCategoryDescription") var categoryDescription : String?

)