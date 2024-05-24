package com.example.quotesapi.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapi.repository.Repository
import com.example.quotesapi.data.model.QuoteResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class QuotesViewModel @Inject constructor(private val repository: Repository) : ViewModel(){



     private val _quotesFlow = MutableStateFlow<List<QuoteResponse>?>(null)
     val quotesFlow: StateFlow<List<QuoteResponse>?> = _quotesFlow.asStateFlow()

     init {
          viewModelScope.launch {
              withContext(Dispatchers.IO){
                  fetchQuotes("all")
              }

          }
     }

    private suspend fun fetchQuotes(category: String) {

        val response = repository.getQuotes(category)

        if (response.isSuccessful) {
            viewModelScope.launch {
                withContext(Dispatchers.IO){
                    _quotesFlow.emit(response.body())  // Update state flow with response
                }
            }
            Log.d("QUOTESVIEWMODEL", "onSuccess} ${response.body()} ")
        } else {
            Log.d("QUOTESVIEWMODEL", "failed response"+ response.raw().message)
        }


     }
}