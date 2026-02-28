package com.surajvanshsv.quativa.repository

import com.surajvanshsv.quativa.model.QuoteResponse
import com.surajvanshsv.quativa.retrofit.ApiInterface
import retrofit2.Response

class QuoteRepository(
    private val apiInterface: ApiInterface
) {

    suspend fun getQuote() : Response<QuoteResponse> {
        return apiInterface.getRandomQuote()
    }



}