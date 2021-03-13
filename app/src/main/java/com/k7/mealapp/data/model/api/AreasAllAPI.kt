package com.k7.mealapp.data.model.api

import com.google.gson.annotations.SerializedName


data class AreasAllAPI (

    @SerializedName("meals") var areas : List<AreaAPI>

)
