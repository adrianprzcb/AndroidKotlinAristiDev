package com.adrian.horoscapp.domain

import com.adrian.horoscapp.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sign: String): PredictionModel?
}