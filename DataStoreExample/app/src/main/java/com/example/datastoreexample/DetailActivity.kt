package com.example.datastoreexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val viewBackground = findViewById<View>(R.id.viewBackground)
        val tvName = findViewById<TextView>(R.id.tvName)

        lifecycleScope.launch(Dispatchers.IO){
            getUserProfile().collect{
                withContext(Dispatchers.Main){
                    tvName.text = it.name

                    if(it.vip){
                        viewBackground.setBackgroundResource(R.color.teal_200)
                    }
                }
            }
        }

    }



    private fun getUserProfile() = dataStore.data.map { preferences ->
        UserProfile(
        preferences[stringPreferencesKey("name")].orEmpty(),
        preferences[booleanPreferencesKey("VIP")] ?: false
        )
    }
}