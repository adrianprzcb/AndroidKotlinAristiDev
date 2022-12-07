
package com.adrian.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
  private var name: String? = null
    private var address: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
           name = it.getString(NAME_BUNDLE)
            address = it.getString(ADRESS_BUNDLE)
            Log.i("awas" , name.orEmpty())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    companion object {
         const val NAME_BUNDLE = "name_bundle"
         const val ADRESS_BUNDLE = "adress_bundle"

        @JvmStatic
        fun newInstance(name: String, address: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME_BUNDLE, name)
                    putString(ADRESS_BUNDLE, address)
                }
            }
    }
}