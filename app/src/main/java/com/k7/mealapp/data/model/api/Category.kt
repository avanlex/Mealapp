package com.k7.mealapp.data.model.api

import com.google.gson.annotations.SerializedName

data class Category (

    @SerializedName("idCategory") var idCategory : String,
    @SerializedName("strCategory") var category : String,
    @SerializedName("strCategoryThumb") var categoryThumb : String,
    @SerializedName("strCategoryDescription") var categoryDescription : String

)