package com.k7.mealapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.k7.mealapp.R
import com.k7.mealapp.models.dto.MealDto

class MealsRecyclerViewAdapter : RecyclerView.Adapter<MealViewHolder>() {
    private var onOpenDetailsClickListener: OnItemClickListener? = null
    private var meals: List<MealDto> = listOf()

    fun setOnOpenMealDetailsClickListener(listener: OnItemClickListener?){
        if (listener != null) {
            onOpenDetailsClickListener = listener
        }
    }

    fun bind(MealList: List<MealDto>) {
        meals = MealList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_holder_meal, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bindItem(meals[position],
                onOpenDetailsClickListener
        )
    }

    override fun getItemCount(): Int = meals.size
}

fun interface OnItemClickListener {
    fun onClick(Meal: MealDto)
}

class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.tv_meal_name_holder)
    private val poster: ShapeableImageView = itemView.findViewById(R.id.iv_meal_image_holder)

    fun bindItem(meal: MealDto,
                 onOpenDetails: OnItemClickListener?
    ) {
        name.text = meal.name

        poster.load(meal.imageSource) {
            crossfade(true)
            placeholder(R.drawable.ic_meal)
            error(R.drawable.ic_broken)
        }
    }
}
