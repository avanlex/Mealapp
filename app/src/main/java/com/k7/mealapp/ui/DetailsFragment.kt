package com.k7.mealapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.k7.mealapp.R
import com.k7.mealapp.models.dto.MealDto
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailsFragment(
        meal : MealDto
) : Fragment(R.layout.details_fragment) {


//    companion object {
//        fun newInstance() = DetailsFragment(null)
//    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<DetailsViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}