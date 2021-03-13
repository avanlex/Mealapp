package com.k7.mealapp.network


import com.k7.mealapp.model.api.*
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiService {

    //Выдает список блюд определенной страны
    @GET("filter.php")
    suspend fun getMealFromArea(@Query("a") category: String): SearchMainIngredientAndAreaAndCategoryAPI

    //Выдает список блюд нужной категории
    @GET("filter.php")
    suspend fun getMealFromCategory(@Query("c") category: String): SearchMainIngredientAndAreaAndCategoryAPI

    //Выдает список блюд с главным блюдом
    @GET("filter.php")
    suspend fun getMealForFindMainIngredient(@Query("i") mainIgridient: String): SearchMainIngredientAndAreaAndCategoryAPI

    //Выдает список возможных ингридиентов
    @GET("list.php?i=list")
    suspend fun getAllIngredientsFood(): IngredientsAPI

    //Выдает список стран откуда блюда
    @GET("list.php?a=list")
    suspend fun getAllAreaFood(): AreaAPI

    //Выдает список возможных категорий
    @GET("categories.php")
    suspend fun getAllCategoriesFood(): CategoriesAPI

    //Выдает рандомное блюдо
    @GET("random.php")
    suspend fun getSearchFoodRandom(): SearchAPI

    //Поиск блюда по id
    @GET("lookup.php")
    suspend fun getSearchFoodID(@Query("i") id: Int): SearchAPI

    //Поиск по названию блюда(блюд)
    @GET("search.php")
    suspend fun getSearchFoodName(@Query("s") name: String): SearchAPI

}