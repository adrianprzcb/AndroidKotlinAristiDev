package com.adrian.mylibrary

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class Botonaco @JvmOverloads constructor(
    context: Context,
    attrs:AttributeSet? = null,
    defStyleAttr:Int = 0,
    defStyleRes:Int = 0
) :LinearLayout(context, attrs, defStyleAttr, defStyleRes) {
    init {
        inflate(context, R.layout.botonaco, this)
    }

}