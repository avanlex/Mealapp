package com.k7.mealapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.RecyclerView
import com.k7.mealapp.R
import com.k7.mealapp.model.api.SearchAPI
import com.k7.mealapp.models.dto.MealDto
import com.k7.mealapp.models.dto.convertToPojo
import com.k7.mealapp.network.Network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SeachFragment : Fragment(),MealsRecyclerViewAdapterSearch.OnItemClickListener {
    lateinit var meal: String
    lateinit var listFoundMeals:List<MealDto>
    private var recycler: RecyclerView? = null
    private var adapterMeals: MealsRecyclerViewAdapterSearch =MealsRecyclerViewAdapterSearch(this)
    private var listener: ClickListener? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<ExploreViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setListener(l: ClickListener) {
        listener = l
    }

    interface ClickListener {
       // fun openMovieDetall(data: Movie)
    }

    private fun loadSavedState(){
        meal = requireArguments().getString(MEAL_KEY)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSavedState()

        val net = Network()
        recycler =view.findViewById(R.id.rvMealFound)
        CoroutineScope(Dispatchers.Main).launch {
            val listApi = net.searchFoodName(meal)
            val needList=getmeals(listApi)
            var d = needList
            adapterMeals.setData(needList) // bind(,)
            recycler?.adapter = adapterMeals
        }
    }

   fun getmeals(mealsList:SearchAPI): List<MealDto>{
        println("REPO" + mealsList.meals)
        return      mealsList.meals.map { it.convertToPojo() }
   }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    companion object {
        const val MEAL_KEY = "MEAL_LIST"
        fun newInstance(meal: String): SeachFragment {
            val fragment = SeachFragment()
            val args = Bundle()
            args.putString(MEAL_KEY, meal)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onItemClick(meal: MealDto) {
        requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(meal))
                .addToBackStack(null)
                .commit()
    }

}