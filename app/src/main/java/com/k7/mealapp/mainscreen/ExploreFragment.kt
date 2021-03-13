package com.k7.mealapp.mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.k7.mealapp.R
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ExploreFragment : Fragment(R.layout.explore_fragment) {

    companion object {
        fun newInstance() = ExploreFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<ExploreViewModel> { viewModelFactory }

//    private fun openRecipeDetails(recipe: Recipe) {
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.main_activity, FragmentMoviesDetails.newInstance(movie))
//            .addToBackStack(null)
//            .commit()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}