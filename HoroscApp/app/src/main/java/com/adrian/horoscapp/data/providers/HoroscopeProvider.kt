package com.adrian.horoscapp.data.providers

import com.adrian.horoscapp.domain.model.HoroscopeInfo
import com.adrian.horoscapp.domain.model.HoroscopeInfo.*;
import javax.inject.Inject

class HoroscopeProvider @Inject constructor(){

    fun getHoroscopes():List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}