package com.adrian.horoscapp.domain

interface Repository {

    suspend fun getPrediction(sign: String)
}