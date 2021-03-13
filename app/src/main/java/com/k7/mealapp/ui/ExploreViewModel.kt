package com.k7.mealapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.k7.mealapp.models.dto.MealDto
import com.k7.mealapp.repository.MealRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExploreViewModel @Inject constructor(
    private val repository: MealRepository
) : ViewModel() {
    private val _mealList: MutableLiveData<List<MealDto>> = MutableLiveData(emptyList())
    val mealList: LiveData<List<MealDto>> = _mealList

    fun getMeal() {
        if (_mealList.value?.isEmpty() == true) {
            viewModelScope.launch {
                repository.getRandomMeals()
            }
        }
    }
}