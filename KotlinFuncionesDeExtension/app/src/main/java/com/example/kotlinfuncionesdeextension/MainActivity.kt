package com.example.kotlinfuncionesdeextension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = "Aris"
        var happyName = name.happy()


        val age:Int? = null

        if(age.isNUll()){

        }else{

        }



         toast("gege")
        toast("gege",Toast.LENGTH_LONG)


      //  val imageView: ImageView = findViewById(R.id.imageView)
       // imageView.load("")



//         editText.onTextChanged { "El carácter añadido es $it" }

    }
}