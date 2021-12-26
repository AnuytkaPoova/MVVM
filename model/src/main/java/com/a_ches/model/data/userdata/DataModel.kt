package com.a_ches.model.data.userdata

import com.google.gson.annotations.SerializedName

data class DataModel(
    val text: String = "",
    val meanings: List<Meaning> = listOf()
)
