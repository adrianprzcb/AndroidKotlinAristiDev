package com.adrian.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.adrian.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.adrian.horoscapp.ui.horoscope.HoroscopeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args:HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }

    private fun initUi() {
        initUiState()
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect{
                    when(it){
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState()
                    }
                }
            }
        }
    }

    private fun successState() {
        TODO("Not yet implemented")
    }

    private fun errorState() {
        TODO("Not yet implemented")
    }


    private fun loadingState(){
        binding.pb.isVisible = true
    }
}