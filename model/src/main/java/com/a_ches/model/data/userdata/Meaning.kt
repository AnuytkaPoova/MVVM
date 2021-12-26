package com.a_ches.model.data.userdata

import com.google.gson.annotations.SerializedName

data class Meaning(
    val translatedMeaning: TranslatedMeaning = TranslatedMeaning(),
    val imageUrl: String = ""
)
