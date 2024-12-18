package com.adrian.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.adrian.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.adrian.horoscapp.ui.horoscope.HoroscopeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeViewModel by viewModels()

    private val args:HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        args.type
    }
}