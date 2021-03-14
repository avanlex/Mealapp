package com.k7.mealapp.models.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MealDto(
    var idMeal : Int,
    var name : String,
    var drinkAlternate : String,
    var category : String,
    var area : String,
    var instructions : String,
    var mealThumb : String,
    var tags : String,
    var youtube : String,
    var ingredient : List<String>,
    var measure : List<String>,
    var source : String,
    var imageSource : String,
    var creativeCommonsConfirmed : String,
    var dateModified : String
):Parcelable

