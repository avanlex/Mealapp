package com.k7.mealapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.k7.mealapp.model.api.MealAPI
import com.k7.mealapp.models.dto.MealDto
import com.k7.mealapp.ui.DetailsFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SeachFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SeachFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit  var meal: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private fun loadSavedState(){
        meal = requireArguments().getString(SeachFragment.MEAL_KEY)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSavedState()

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