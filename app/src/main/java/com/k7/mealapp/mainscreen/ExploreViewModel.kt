package com.k7.mealapp.mainscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.k7.mealapp.models.dto.MealDto
import kotlinx.coroutines.launch

class ExploreViewModel(
    mealListProvider: IMealListProvider
) : ViewModel() {
    private val _mealList: MutableLiveData<List<MealDto>> = MutableLiveData(emptyList())
    val mealList: LiveData<List<MealDto>> = _mealList

    fun getMeal(mealId: Int) {
        if (_mealList.value?.isEmpty() == true) {
            viewModelScope.launch {
                //_mealList.value = mealListProvider.getMeal(mealId)
            }
        }
    }
}