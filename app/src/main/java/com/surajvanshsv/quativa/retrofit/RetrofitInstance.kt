package com.surajvanshsv.quativa.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Singleton
class RetrofitInstance {


    val apiInterface : ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://favqs.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }




}