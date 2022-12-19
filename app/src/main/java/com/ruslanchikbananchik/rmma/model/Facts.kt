package com.ruslanchikbananchik.rmma.model

import com.google.gson.annotations.SerializedName

data class Facts(
    @SerializedName("data")
    var facts: List<String>
)
