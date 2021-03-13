package com.k7.mealapp.mainscreen

import androidx.lifecycle.ViewModel
import com.k7.mealapp.repository.MealRepository
import javax.inject.Inject

class ExploreViewModel @Inject constructor(
    private val repository: MealRepository
) : ViewModel() {

}