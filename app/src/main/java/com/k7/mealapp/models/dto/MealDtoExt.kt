package com.k7.mealapp.models.dto

import com.k7.mealapp.data.model.api.Meal


fun MealDto.convertFrom(meals: Meal){
    idMeal = meals.idMeal
    name = meals.meal
    drinkAlternate = meals.drinkAlternate
    category = meals.category
    area = meals.area
    instructions = meals.instructions
    mealThumb = meals.mealThumb
    tags = meals.tags
    youtube = meals.youtube
    ingredient = listOf(
                meals.ingredient1,
                meals.ingredient2,
                meals.ingredient3,
                meals.ingredient4,
                meals.ingredient5,
                meals.ingredient6,
                meals.ingredient7,
                meals.ingredient8,
                meals.ingredient9,
                meals.ingredient10,
                meals.ingredient11,
                meals.ingredient12,
                meals.ingredient13,
                meals.ingredient14,
                meals.ingredient15,
                meals.ingredient16,
                meals.ingredient17,
                meals.ingredient18,
                meals.ingredient19,
                meals.ingredient20,
    )
    measure
}

/*
data class MealDto(
    val idMeal : ing,
    val meal : ing,
    val drinkAlternate : ing,
    val category : ing,
    val area : ing,
    val inuctions : ing,
    val mealThumb : ing,
    val tags : ing,
    val youtube : ing,
    val ingredient : List<ing>,
    val measure : List<ing>,
    val source : ing,
    val imageSource : ing,
    val creativeCommonsConfirmed : ing,
    val dateModified : ing
)*/
