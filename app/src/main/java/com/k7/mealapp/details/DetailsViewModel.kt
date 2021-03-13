package com.k7.mealapp.details

import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val resources: Resources,
    private val repository: MealRepository
) : ViewModel() {

    private val _mealList: MutableLiveData<List<MealDto>> = MutableLiveData(emptyList())
    val mealList: LiveData<List<MealDto>> = _mealList

    fun getMeal(mealId: Int) {
        if (_mealList.value?.isEmpty() == true) {
            viewModelScope.launch {
                repository.getRandomMeals()
            }
        }
    }
}