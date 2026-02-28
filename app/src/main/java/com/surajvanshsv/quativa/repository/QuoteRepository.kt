package com.surajvanshsv.quativa.repository

import com.surajvanshsv.quativa.model.Quote
import com.surajvanshsv.quativa.model.QuoteResponse
import com.surajvanshsv.quativa.retrofit.ApiInterface
import com.surajvanshsv.quativa.room.QuotesDAO
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val quotesDAO: QuotesDAO
) {

    suspend fun getQuote() : Response<QuoteResponse> {
        return apiInterface.getRandomQuote()
    }

    suspend fun insertQuote(quote: Quote) {
        quotesDAO.insertQuote(quote)
    }

    val quoteItemFromDB: Flow<List<Quote>> = quotesDAO.getQuotes()


    suspend fun deleteQuoteItem(quote: Quote) {
        quotesDAO.deleteQuoteItem(quote)
    }



}