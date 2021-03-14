package com.k7.mealapp.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.k7.mealapp.R
import com.k7.mealapp.models.dto.MealDto
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExploreFragment : Fragment(R.layout.explore_fragment) {

    companion object {
        fun newInstance() = ExploreFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<ExploreViewModel> { viewModelFactory }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    private lateinit var rvMeals : RecyclerView
    //    private lateinit var pbLoading : ProgressBar
    private lateinit var adapterMeals: MealsRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(view)
        initMealsRecyclerView()

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getMealsFlow().collect {
                adapterMeals.bind(it)
            }
        }

        val textSearch = view.findViewById<EditText>(R.id.edTVSearchWrite)
        val bSearch = view.findViewById<ImageView>(R.id.icsearchStart)
        bSearch.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, SeachFragment.newInstance(textSearch.text.toString()))
                .addToBackStack(null)
                .commit()
        }
    }

    private fun initView(v: View) {
        rvMeals = v.findViewById(R.id.rv_meals)
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

    private fun onSearch(meal: MealDto) {
//
    }

    private fun openMealDetails(meal: MealDto) {
        requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(meal))
                .addToBackStack(null)
                .commit()
    }
}