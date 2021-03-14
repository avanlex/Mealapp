package com.k7.mealapp.model.api

import android.os.Parcel
import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


data class MealAPI (

    @SerializedName("idMeal") var idMeal : Int,
    @SerializedName("strMeal") var meal : String?,
    @SerializedName("strDrinkAlternate") var drinkAlternate : String?,
    @SerializedName("strCategory") var category : String?,
    @SerializedName("strArea") var area : String?,
    @SerializedName("strInstructions") var instructions : String?,
    @SerializedName("strMealThumb") var mealThumb : String?,
    @SerializedName("strTags") var tags : String?,
    @SerializedName("strYoutube") var youtube : String?,
    @SerializedName("strIngredient1") var ingredient1 : String?,
    @SerializedName("strIngredient2") var ingredient2 : String?,
    @SerializedName("strIngredient3") var ingredient3 : String?,
    @SerializedName("strIngredient4") var ingredient4 : String?,
    @SerializedName("strIngredient5") var ingredient5 : String?,
    @SerializedName("strIngredient6") var ingredient6 : String?,
    @SerializedName("strIngredient7") var ingredient7 : String?,
    @SerializedName("strIngredient8") var ingredient8 : String?,
    @SerializedName("strIngredient9") var ingredient9 : String?,
    @SerializedName("strIngredient10") var ingredient10 : String?,
    @SerializedName("strIngredient11") var ingredient11 : String?,
    @SerializedName("strIngredient12") var ingredient12 : String?,
    @SerializedName("strIngredient13") var ingredient13 : String?,
    @SerializedName("strIngredient14") var ingredient14 : String?,
    @SerializedName("strIngredient15") var ingredient15 : String?,
    @SerializedName("strIngredient16") var ingredient16 : String?,
    @SerializedName("strIngredient17") var ingredient17 : String?,
    @SerializedName("strIngredient18") var ingredient18 : String?,
    @SerializedName("strIngredient19") var ingredient19 : String?,
    @SerializedName("strIngredient20") var ingredient20 : String?,
    @SerializedName("strMeasure1") var measure1 : String?,
    @SerializedName("strMeasure2") var measure2 : String?,
    @SerializedName("strMeasure3") var measure3 : String?,
    @SerializedName("strMeasure4") var measure4 : String?,
    @SerializedName("strMeasure5") var measure5 : String?,
    @SerializedName("strMeasure6") var measure6 : String?,
    @SerializedName("strMeasure7") var measure7 : String?,
    @SerializedName("strMeasure8") var measure8 : String?,
    @SerializedName("strMeasure9") var measure9 : String?,
    @SerializedName("strMeasure10") var measure10 : String?,
    @SerializedName("strMeasure11") var measure11 : String?,
    @SerializedName("strMeasure12") var measure12 : String?,
    @SerializedName("strMeasure13") var measure13 : String?,
    @SerializedName("strMeasure14") var measure14 : String?,
    @SerializedName("strMeasure15") var measure15 : String?,
    @SerializedName("strMeasure16") var measure16 : String?,
    @SerializedName("strMeasure17") var measure17 : String?,
    @SerializedName("strMeasure18") var measure18 : String?,
    @SerializedName("strMeasure19") var measure19 : String?,
    @SerializedName("strMeasure20") var measure20 : String?,
    @SerializedName("strSource") var source : String?,
    @SerializedName("strImageSource") var imageSource : String?,
    @SerializedName("strCreativeCommonsConfirmed") var creativeCommonsConfirmed : String?,
    @SerializedName("dateModified") var dateModified : String?

)
