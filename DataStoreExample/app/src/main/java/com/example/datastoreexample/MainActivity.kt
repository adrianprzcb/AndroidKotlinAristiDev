package com.example.datastoreexample

import android.content.ClipData.newIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val Context.dataStore  by preferencesDataStore(name = "USER_PREFERENCES_NAME")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSave = findViewById<Button>(R.id.btnSave)
        val editText = findViewById<EditText>(R.id.editText)
        val cbVIP = findViewById<CheckBox>(R.id.cbVIP)

        btnSave.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO) {
                saveValues(editText.text.toString(), cbVIP.isChecked)
            }
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }


    }

    private suspend fun saveValues(name: String, checked: Boolean) {
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey("name")]= name
            preferences[booleanPreferencesKey("VIP")] = checked
        }
    }
}