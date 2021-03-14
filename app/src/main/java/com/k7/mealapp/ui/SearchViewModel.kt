package com.k7.mealapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.k7.mealapp.models.dto.MealDto
import com.k7.mealapp.repository.MealRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

import java.util.concurrent.Flow
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val repository: MealRepository
) : ViewModel() {
    private val _mealList: MutableLiveData<List<MealDto>> = MutableLiveData(emptyList())
    val mealList: LiveData<List<MealDto>> = _mealList

    fun getMealsFlow() = flow {
            emit(repository.getRandomMeals())
    }
}