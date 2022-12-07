package com.example.admobejemplo

import android.app.Application
import com.google.android.gms.ads.MobileAds

class admbobejemploapp:Application() {
     override fun onCreate() {
            super.onCreate()
            MobileAds.initialize(this)
        }
    }
