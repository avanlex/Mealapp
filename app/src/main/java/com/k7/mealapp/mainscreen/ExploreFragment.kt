package com.k7.mealapp.mainscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.k7.mealapp.R

class ExploreFragment : Fragment() {

    companion object {
        fun newInstance() = ExploreFragment()
    }

    private lateinit var viewModel: ExploreViewModel

//    private fun openRecipeDetails(recipe: Recipe) {
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.main_activity, FragmentMoviesDetails.newInstance(movie))
//            .addToBackStack(null)
//            .commit()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.explore_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExploreViewModel::class.java)
        // TODO: Use the ViewModel
    }

}