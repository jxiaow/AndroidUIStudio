package com.xw.palatedesign

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView

class MyScrollView @JvmOverloads constructor(context: Context, attributes: AttributeSet? = null,
                                             style: Int = 0) : ScrollView(context, attributes, style) {

    private var code: ((alpha: Float) -> Unit)? = null

    fun setAlphaChange(f: (alpha: Float) -> Unit) {
        this.code = f
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        code?.let {
            val heightPixels = resources.displayMetrics.heightPixels

            if (scrollY <= heightPixels / 3f) {
                it(1 - (scrollY / (heightPixels / 3f)))
            }
        }
        super.onScrollChanged(l, t, oldl, oldt)
    }
}