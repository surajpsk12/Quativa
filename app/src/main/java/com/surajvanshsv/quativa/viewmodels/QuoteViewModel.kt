package com.surajvanshsv.quativa.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surajvanshsv.quativa.model.Quote
import com.surajvanshsv.quativa.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository
): ViewModel() {


    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> get() = _quote

    init {
        getQuote()
    }


    // saved quote logics
    val allQuote : Flow<List<Quote>> = quoteRepository.quoteItemFromDB

    fun insertQuote(quote: Quote) {
        viewModelScope.launch {
            quoteRepository.insertQuote(quote)
        }
    }

    fun deleteQuoteItem(quote: Quote) {
        viewModelScope.launch {
            quoteRepository.deleteQuoteItem(quote)
        }
    }





    fun getQuote(){
        viewModelScope.launch {
            try{
                val response = quoteRepository.getQuote()
                if(response.isSuccessful){
                    val quoteResponse = response.body()
                    _quote.value = quoteResponse?.quote

                }
            } catch (e: Exception){
                _quote.value = null
            }
        }
    }


}