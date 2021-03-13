package com.k7.mealapp.network

import com.k7.mealapp.data.*
import com.k7.mealapp.model.api.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

class Network {

    //Поиск по названию блюда(блюд)
   suspend fun  searchFoodName(nameMeal:String): SearchAPI?= withContext(Dispatchers.IO) {
       RetrofitModule.mealApi.getSearchFoodName(nameMeal)
    }

    //Поиск блюда по id
    suspend fun  searchFoodID(id:Int): SearchAPI?= withContext(Dispatchers.IO) {
        RetrofitModule.mealApi.getSearchFoodID(id)
    }

    //Выдает рандомное блюдо
    suspend fun  searchFoodRandom(): SearchAPI?= withContext(Dispatchers.IO) {
        RetrofitModule.mealApi.getSearchFoodRandom()
    }

    //Выдает список возможных категорий
    suspend fun  allCategoriesFood(): CategoriesAPI?= withContext(Dispatchers.IO) {
        RetrofitModule.mealApi.getAllCategoriesFood()
    }

    //Выдает список стран откуда блюда
    suspend fun  allAreaFood(): AreasAPI?= withContext(Dispatchers.IO) {
        RetrofitModule.mealApi.getAllAreaFood()
    }

    //Выдает список возможных ингридиентов
    suspend fun  allIngredientsFood(): IngredientsAPI?= withContext(Dispatchers.IO) {
        RetrofitModule.mealApi.getAllIngredientsFood()
    }

    //Выдает список блюд с главным блюдом
    suspend fun  searchMealForMainIngredient(mainIgridient: String): SearchMainIngredientAndAreaAndCategoryAPI?= withContext(Dispatchers.IO) {
        RetrofitModule.mealApi.getMealForFindMainIngredient(mainIgridient)
    }

    //Выдает список блюд нужной категории
    suspend fun  searchMealForCategory(category: String): SearchMainIngredientAndAreaAndCategoryAPI?= withContext(Dispatchers.IO) {
        RetrofitModule.mealApi.getMealFromCategory(category)
    }

    //Выдает список блюд определенной страны
    suspend fun  searchMealForArea(area: String): SearchMainIngredientAndAreaAndCategoryAPI?= withContext(Dispatchers.IO) {
        RetrofitModule.mealApi.getMealFromArea(area)
    }

    private interface MealApi {
        //Выдает список блюд определенной страны
        @GET("filter.php")
        suspend fun getMealFromArea(@Query("a") category: String ): SearchMainIngredientAndAreaAndCategoryAPI

        //Выдает список блюд нужной категории
        @GET("filter.php")
        suspend fun getMealFromCategory(@Query("c") category: String ): SearchMainIngredientAndAreaAndCategoryAPI

        //Выдает список блюд с главным блюдом
        @GET("filter.php")
        suspend fun getMealForFindMainIngredient(@Query("i") mainIgridient: String ): SearchMainIngredientAndAreaAndCategoryAPI

        //Выдает список возможных ингридиентов
        @GET("list.php?i=list")
        suspend fun getAllIngredientsFood(): IngredientsAPI

        //Выдает список стран откуда блюда
        @GET("list.php?a=list")
        suspend fun getAllAreaFood(): AreasAPI

        //Выдает список возможных категорий
        @GET("categories.php")
        suspend fun getAllCategoriesFood(): CategoriesAPI

        //Выдает рандомное блюдо
        @GET("random.php")
        suspend fun getSearchFoodRandom(): SearchAPI

        //Поиск блюда по id
        @GET("lookup.php")
        suspend fun getSearchFoodID(@Query("i") id: Int ): SearchAPI

        //Поиск по названию блюда(блюд)
        @GET("search.php")
        suspend fun getSearchFoodName(@Query("s") name: String ): SearchAPI
    }
    private object RetrofitModule {
             private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val mealApi: MealApi = retrofit.create()
    }
}