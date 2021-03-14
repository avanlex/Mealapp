package com.k7.mealapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.k7.mealapp.R
import com.k7.mealapp.models.dto.MealDto



                                                                                    //RecyclerView.Adapter<MealsRecyclerViewAdapterSearch.EmptyViewHolder>()
class MealsRecyclerViewAdapterSearch(private val listener:OnItemClickListener) : RecyclerView.Adapter<MealsRecyclerViewAdapterSearch.EmptyViewHolder>() {
    private var data = listOf<MealDto>()


    interface OnItemClickListener {
       // fun onItemClick(data: MealDto)
        fun onItemClick(meal:MealDto)

    }

    fun setData(datatemp: List<MealDto>) {
        this.data = datatemp
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmptyViewHolder {

        val itemView =LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_meal,
                parent,
                false
        )
        return EmptyViewHolder(itemView)
        // return EmptyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false))

    }
    ////////////

    ////////////

    override fun onBindViewHolder(holder: EmptyViewHolder, position: Int) {


        holder.onBind(data[position],listener)


    }
    // override fun getItemCount(): Int = 4
    override fun getItemCount(): Int {
        return data.count()
    }
    override fun getItemViewType(position: Int): Int {

        return 0
    }
    //////////////////////////
    class EmptyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val name: TextView = itemView.findViewById(R.id.tv_meal_name_holder)
        private val poster: ShapeableImageView = itemView.findViewById(R.id.iv_meal_image_holder)
        fun onBind(data: MealDto, listener: OnItemClickListener) {

            name.text = data.name

            // itemView.setOnClickListener{onOpenDetails?.onClick(meal)}
            itemView.setOnClickListener { listener.onItemClick(data) }

            poster.load(data.mealThumb) {
                crossfade(true)
                placeholder(R.drawable.ic_meal)
                error(R.drawable.ic_broken)
            }

        }
    }


}
