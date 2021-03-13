package com.k7.mealapp.models.dto

import com.k7.mealapp.model.api.MealAPI

fun MealDto.convertFrom(meal: MealAPI){

    idMeal = meal.idMeal
    name = meal.meal?: ""
    drinkAlternate = meal.drinkAlternate?: ""
    category = meal.category?: ""
    area = meal.area?: ""
    instructions = meal.instructions?: ""
    mealThumb = meal.mealThumb?: ""
    tags = meal.tags?: ""
    youtube = meal.youtube?: ""
    ingredient = listOf(
                meal.ingredient1 ?: "",
                meal.ingredient2 ?: "",
                meal.ingredient3 ?: "",
                meal.ingredient4 ?: "",
                meal.ingredient5 ?: "",
                meal.ingredient6 ?: "",
                meal.ingredient7 ?: "",
                meal.ingredient8 ?: "",
                meal.ingredient9 ?: "",
                meal.ingredient10?: "",
                meal.ingredient11?: "",
                meal.ingredient12?: "",
                meal.ingredient13?: "",
                meal.ingredient14?: "",
                meal.ingredient15?: "",
                meal.ingredient16?: "",
                meal.ingredient17?: "",
                meal.ingredient18?: "",
                meal.ingredient19?: "",
                meal.ingredient20?: "",
    )
    measure= listOf(
            meal.measure1 ?: "",
            meal.measure2 ?: "",
            meal.measure3 ?: "",
            meal.measure4 ?: "",
            meal.measure5 ?: "",
            meal.measure6 ?: "",
            meal.measure7 ?: "",
            meal.measure8 ?: "",
            meal.measure9 ?: "",
            meal.measure10?: "",
            meal.measure11?: "",
            meal.measure12?: "",
            meal.measure13?: "",
            meal.measure14?: "",
            meal.measure15?: "",
            meal.measure16?: "",
            meal.measure17?: "",
            meal.measure18?: "",
            meal.measure19?: "",
            meal.measure20?: "",
    )
    source = meal.source?: ""
    imageSource = meal.imageSource?: ""
    creativeCommonsConfirmed = meal.creativeCommonsConfirmed?: ""
    dateModified = meal.dateModified?: ""
}

