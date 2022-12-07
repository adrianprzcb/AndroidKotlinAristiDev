package com.adrian.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.adrian.fragments.FirstFragment.Companion.ADRESS_BUNDLE
import com.adrian.fragments.FirstFragment.Companion.NAME_BUNDLE

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val bundle = bundleOf( NAME_BUNDLE to "Adrian", ADRESS_BUNDLE to "Calle 1")
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragmentContainer , args = bundle)
            }
        }

    }
}