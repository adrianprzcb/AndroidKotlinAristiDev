package com.adrian.horoscapp.data

import android.util.Log
import com.adrian.horoscapp.data.network.HoroscopeApiService
import com.adrian.horoscapp.data.network.response.PredictionResponse
import com.adrian.horoscapp.domain.Repository
import com.adrian.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) :Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
         runCatching { apiService.getHoroscope(sign) }
             .onSuccess {
                 return it.toDomain()
             }
             .onFailure {
                 Log.i("aris", " Ha ocurrido un error ${it.message}")
             }
        return null
    }
}