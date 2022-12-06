package com.ruslanchikbananchik.rmma.`interface`

import com.ruslanchikbananchik.rmma.model.Fact
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("?count=3")

    fun getFactsList(): Call<MutableList<Fact>>
}