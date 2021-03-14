package com.k7.mealapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.k7.mealapp.R
import com.k7.mealapp.models.dto.MealDto
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
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
//        Log.d("TAG", "onActivityCreated: ${viewModel.getMeals()}")
//        viewModel.getMeals()
    }

    private lateinit var rvMeals : RecyclerView
    //    private lateinit var pbLoading : ProgressBar
    private lateinit var adapterMeals: MealsRecyclerViewAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
        initMealsRecyclerView()
//        viewModel.loadMovies()
//        viewModel.mealsList.observe(this.viewLifecycleOwner, this.adapterMovies::bindMovies)
//        viewModel.loadingState.observe(this.viewLifecycleOwner, this::setProgressVisibility)
//        viewModel.addToFavorite.observe(this.viewLifecycleOwner, this.adapterMovies::notifyItemChanged)
//        viewModel.getMeals()
//        viewModel.mealList.observe(this.viewLifecycleOwner, this.adapterMeals::bind)
//        lifecycleScope.launch {
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getMealsFlow().collect {
                adapterMeals.bind(it)
            }
        }

    }

//    private fun setProgressVisibility(state: Boolean) {
//        pbLoading.visibility = if (state) ProgressBar.VISIBLE else ProgressBar.GONE
//    }

    private fun initView(v: View) {
        rvMeals = v.findViewById(R.id.rv_meals)
//        pbLoading = v.findViewById(R.id.pb_loading)
    }


    private fun initMealsRecyclerView() {
        // Optimize performance a little
        rvMeals.setHasFixedSize(true)

        // Linear List
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rvMeals.layoutManager = layoutManager

        // Setting adapter to RecyclerView
        adapterMeals = MealsRecyclerViewAdapter()
        rvMeals.adapter = adapterMeals

        adapterMeals.setOnOpenMealDetailsClickListener{ openMealDetails(it) }
    }

    private fun openMealDetails(meal: MealDto) {
        requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(meal))
                .addToBackStack(null)
                .commit()
    }
}