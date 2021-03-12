package com.k7.mealapp.persistent

object MealDatabaseContract {

    const val DATABASE_NAME = "Meals.db"

    object Meal {
        const val TABLE_NAME = "meals"
        const val COLUMN_MEAL_ID = "meal_id"
        const val COLUMN_MEAL_NAME = "meal_name"
        const val COLUMN_MEAL_CATEGORY = "meal_category"
        const val COLUMN_MEAL_AREA = "meal_area"
        const val COLUMN_MEAL_INSTRUCTIONS = "meal_instructions"
        const val COLUMN_MEAL_THUMB_URL = "meal_thumb_url"
        const val COLUMN_MEAL_INGREDIENTS = "meal_ingredients"
        const val COLUMN_MEAL_LAST_VIEW_TIME = "meal_last_view_time"

    }

}