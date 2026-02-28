package com.surajvanshsv.quativa.retrofit

import com.surajvanshsv.quativa.model.QuoteResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {


    @GET("qotd")
    suspend fun getRandomQuote(): Response<QuoteResponse>





}