package com.example.imagepickernew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.*

class MainActivity : AppCompatActivity() {

    val pickMedia = registerForActivityResult(PickVisualMedia()) { uri ->
        if(uri != null) {
            ivImage.setImageURI(uri)
        }
        else{

        }
    }

    lateinit var btnImage: Button
    lateinit var ivImage : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnImage = findViewById(R.id.btnImage)
        ivImage = findViewById(R.id.ivImage)
        btnImage.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }
    }
}