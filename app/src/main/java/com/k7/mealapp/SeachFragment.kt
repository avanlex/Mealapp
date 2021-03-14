package com.k7.mealapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.k7.mealapp.model.api.SearchAPI
import com.k7.mealapp.models.dto.MealDto
import com.k7.mealapp.models.dto.convertToPojo
import com.k7.mealapp.network.Network
import com.k7.mealapp.ui.DetailsFragment

import com.k7.mealapp.ui.MealsRecyclerViewAdapterSearch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [SeachFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class SeachFragment : Fragment(),MealsRecyclerViewAdapterSearch.OnItemClickListener {
    lateinit  var meal: String
    lateinit var listFoundMeals:List<MealDto>


    private var recycler: RecyclerView? = null
    private lateinit var rvMeals : RecyclerView
    private  var adapterMeals: MealsRecyclerViewAdapterSearch =MealsRecyclerViewAdapterSearch(this)

    private var listener:ClickListener? = null

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
        meal = requireArguments().getString(SeachFragment.MEAL_KEY)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSavedState()

        rvMeals = view.findViewById(R.id.rvMealFound)

        val net = Network()
        recycler =view.findViewById(R.id.rvMealFound)
        CoroutineScope(Dispatchers.Main).launch {
            var listApi = net.searchFoodName(meal)
            var needList=getmeals(listApi)
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
        return inflater.inflate(R.layout.fragment_seach, container, false)
    }

    companion object {
        const val MEAL_KEY = "MEAL"
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

    /*  companion object {
          /**
           * Use this factory method to create a new instance of
           * this fragment using the provided parameters.
           *
           * @param param1 Parameter 1.
           * @param param2 Parameter 2.
           * @return A new instance of fragment SeachFragment.
           */
          // TODO: Rename and change types and number of parameters
          @JvmStatic
          fun newInstance(param1: String, param2: String) =
              SeachFragment().apply {
                  arguments = Bundle().apply {
                      putString(ARG_PARAM1, param1)
                      putString(ARG_PARAM2, param2)
                  }
              }
      }*/

}