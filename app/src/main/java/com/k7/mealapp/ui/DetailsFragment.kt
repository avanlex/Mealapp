package com.k7.mealapp.ui

import android.graphics.ColorFilter
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.k7.mealapp.R
import com.k7.mealapp.models.dto.MealDto
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailsFragment : Fragment(R.layout.details_fragment) {


//    companion object {
//        fun newInstance() = DetailsFragment(null)
//    }

    lateinit  var meal: MealDto
    private lateinit var rvIngridients : RecyclerView
    private lateinit var ingridientsAdapter: IngridientRecyclerViewAdapter
    private lateinit var poster: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvInstructions: TextView
    private lateinit var ivBack: ImageView

    companion object {
        const val MEAL_KEY = "MEAL"
        fun newInstance(meal: MealDto): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            args.putParcelable(MEAL_KEY, meal)
            fragment.arguments = args
            return fragment
        }
    }

    private fun loadSavedState(){
        meal = requireArguments().getParcelable(MEAL_KEY)!!
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSavedState()
        setupUi(view)
        loadPoster()
        initIngridientRecyclerView()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<DetailsViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    private fun setupUi(v : View){
        rvIngridients = v.findViewById(R.id.rv_ingridients)
        poster = v.findViewById(R.id.iv_meal_poster)
        tvTitle = v.findViewById(R.id.tv_meal_name)
        tvInstructions = v.findViewById(R.id.tv_instructions)
        ivBack = v.findViewById(R.id.iv_back)

        tvTitle.text = meal.name
        tvInstructions.text = meal.instructions

        // Listener
        ivBack.setOnClickListener{ parentFragmentManager.popBackStack() }
    }

    private fun loadPoster(){
        poster.load(meal.mealThumb) {
            crossfade(true)
            placeholder(R.drawable.ic_meal)
            error(R.drawable.ic_broken)
        }
//        poster.colorFilter = getGreyScaleFilter()
    }

//    private fun getGreyScaleFilter() : ColorFilter {
//        val matrix = ColorMatrix()
//        matrix.setSaturation(0f)
//        return ColorMatrixColorFilter(matrix)
//    }

    private fun initIngridientRecyclerView() {
        // Optimaze perfomance a little
        rvIngridients.setHasFixedSize(true)

//        // Offset between items workaround
//        val offset = resources.getDimension(R.dimen.actor_item_spacing).toInt()
//        rvIngridients.addItemDecoration(ActorsListItemOffsetDecorator(offset))

        // Linear List
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rvIngridients.layoutManager = layoutManager

        // Setting adapter to RecyclerView
        ingridientsAdapter = IngridientRecyclerViewAdapter()

        ingridientsAdapter.bind(emptyList()) // TODO
        rvIngridients.adapter = ingridientsAdapter
    }

}