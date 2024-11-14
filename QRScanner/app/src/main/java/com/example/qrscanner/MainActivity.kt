package com.example.qrscanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.core.text.HtmlCompat.fromHtml
import com.example.qrscanner.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var qrLink : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnScanner.setOnClickListener{initScanner()}

    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("Scan")
        integrator.setTorchEnabled(true)
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if(result!= null){
            if(result.contents == null){
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "El valor escaneado es:${result.contents} ", Toast.LENGTH_LONG).show()
                qrLink = result.contents
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }

        var linkhtml = "<a href='$qrLink'> $qrLink </a>"
        binding.tvResult.setClickable(true);
        binding.tvResult.text = fromHtml(linkhtml, FROM_HTML_MODE_LEGACY)
    }
}