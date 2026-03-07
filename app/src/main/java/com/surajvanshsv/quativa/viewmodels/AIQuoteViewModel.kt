package com.surajvanshsv.quativa.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.surajvanshsv.quativa.KeyProvider
import com.surajvanshsv.quativa.model.GroqMessage
import com.surajvanshsv.quativa.model.GroqRequest
import com.surajvanshsv.quativa.model.Quote
import com.surajvanshsv.quativa.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AIQuoteViewModel @Inject constructor(
    private val repository: QuoteRepository
) : ViewModel(){


    private val generativeModel = GenerativeModel(
        modelName = "gemini-2.0-flash",
        apiKey = KeyProvider.provideKeyGroq()
    )

    private val _aiQuote = MutableStateFlow<Quote?>(null)
    val aiQuote: StateFlow<Quote?> = _aiQuote.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()


    fun generateQuoteGroq(mood : String){
        viewModelScope.launch {
            _isLoading.value = true
            _aiQuote.value = null

            val apiKey = "Bearer ${KeyProvider.provideKeyGroq()}"
            val prompt = "Generate a high-quality short  quote for someone feeling $mood. " +
                    "Return length of 15-20 words. " +
                    "Return ONLY the quote and author in this format: Quote content | Author. Do not say anything else."


            try {
                val request = GroqRequest(
                    messages = listOf(GroqMessage(role = "user", content = prompt))
                )

                val response = repository.getGroqQuote(apiKey, request)
                val resultText =response.choices.firstOrNull()?.message?.content
                if(resultText !=null && resultText.contains("|")){
                    val parts = resultText.split("|")
                    _aiQuote.value = Quote(
                        id = (0..100000).random(),
                        body = parts[0].trim().replace("\"", ""),
                        author = parts[1].trim()

                    )
                }
            } catch (e: Exception) {
                Log.e("GroqError", "Error: ${e.message}")
                _aiQuote.value = Quote(
                    id = -1,
                    body = "Groq Connection Error: ${e.localizedMessage}",
                    author = "Error")
            } finally {
                _isLoading.value = false
            }
        }
    }



    fun generateQuoteGemini(mood : String) {
        viewModelScope.launch {
            _isLoading.value = true
            _aiQuote.value = null

            val prompt = "Generate a high-quality inspirational quote for someone feeling $mood. " +
                    "Return length of 15-20 words. " +
                    "Return only the quote and author in this format: Quote content | Author"


            try {
                val response = generativeModel.generateContent(prompt)
                val parts =response.text?.split("|")
                if(parts != null && parts.size == 2){
                    _aiQuote.value = Quote(
                        id = (0..100000).random(),
                        body = parts[0].trim(),
                        author = parts[1].trim()
                    )
                } else {
                    _aiQuote.value = Quote(id = -1, body = "Failed to parse AI response.", author = "Error")
                }
            }catch (e: Exception) {
                android.util.Log.e("GeminiError", "Error: ${e.message}", e)
                _aiQuote.value = Quote(id = -1, body =  "Connection Error: ${e.localizedMessage}", author="Error")
            }finally {
                _isLoading.value = false

            }
        }
    }


    fun saveAiQuote(quote: Quote){
        viewModelScope.launch {
            repository.insertQuote(quote)
        }
    }

}