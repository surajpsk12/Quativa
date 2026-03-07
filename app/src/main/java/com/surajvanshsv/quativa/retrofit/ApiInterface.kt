package com.surajvanshsv.quativa.retrofit

import com.surajvanshsv.quativa.model.GroqRequest
import com.surajvanshsv.quativa.model.GroqResponse
import com.surajvanshsv.quativa.model.QuoteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {


    @GET("qotd")
    suspend fun getRandomQuote(): Response<QuoteResponse>

    @POST("https://api.groq.com/openai/v1/chat/completions")
    suspend fun getGroqQuote(
        @Header("Authorization") token: String,
        @Body request: GroqRequest
    ): GroqResponse



}