package com.k7.mealapp.data.dto

import com.k7.mealapp.data.Meals

fun MealDto.convertFrom(meals: Meals){
    idMeal = meals.idMeal
    name = meals.strMeal
    drinkAlternate = meals.strDrinkAlternate
    category = meals.strCategory
    area = meals.strArea
    instructions = meals.strInstructions
    mealThumb = meals.strMealThumb
    tags = meals.strTags
    youtube = meals.strYoutube
    ingredient = listOf(
                meals.strIngredient1,
                meals.strIngredient2,
                meals.strIngredient3,
                meals.strIngredient4,
                meals.strIngredient5,
                meals.strIngredient6,
                meals.strIngredient7,
                meals.strIngredient8,
                meals.strIngredient9,
                meals.strIngredient10,
                meals.strIngredient11,
                meals.strIngredient12,
                meals.strIngredient13,
                meals.strIngredient14,
                meals.strIngredient15,
                meals.strIngredient16,
                meals.strIngredient17,
                meals.strIngredient18,
                meals.strIngredient19,
                meals.strIngredient20,
    )
}

/*
data class MealDto(
    val idMeal : String,
    val meal : String,
    val drinkAlternate : String,
    val category : String,
    val area : String,
    val instructions : String,
    val mealThumb : String,
    val tags : String,
    val youtube : String,
    val ingredient : List<String>,
    val measure : List<String>,
    val source : String,
    val imageSource : String,
    val creativeCommonsConfirmed : String,
    val dateModified : String
)*/
