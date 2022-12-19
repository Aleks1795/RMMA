package com.ruslanchikbananchik.rmma.`interface`

import com.ruslanchikbananchik.rmma.model.Facts
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {
    @GET("?count=30")

    fun getFactsList(): Call<Facts>
}