package com.example.examplemvvm.data.model

import com.example.examplemvvm.data.model.QuoteModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {
    var quotes: List<QuoteModel> = emptyList()
}