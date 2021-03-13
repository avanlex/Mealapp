package com.k7.mealapp.model.api

import com.google.gson.annotations.SerializedName


data class AreasAPI (

    @SerializedName("meals") var areas : List<AreaAPI>

)
