package com.ruslanchikbananchik.rmma.common

import com.ruslanchikbananchik.rmma.`interface`.RetrofitServices
import com.ruslanchikbananchik.rmma.retrofit.RetrofitClient
import retrofit2.Retrofit
import retrofit2.create

object Common {
    private const val BASE_URL = "https://meowfacts.herokuapp.com/"
    val retrofitService: RetrofitServices
         = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}