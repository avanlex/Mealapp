package com.k7.mealapp.data

import com.google.gson.annotations.SerializedName

data class Categories (

    @SerializedName("idCategory") var idCategory : String,
    @SerializedName("strCategory") var strCategory : String,
    @SerializedName("strCategoryThumb") var strCategoryThumb : String,
    @SerializedName("strCategoryDescription") var strCategoryDescription : String

)