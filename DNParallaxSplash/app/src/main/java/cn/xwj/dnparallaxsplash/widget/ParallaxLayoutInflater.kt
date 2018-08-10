package cn.xwj.dnparallaxsplash.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View

/**
 * Author: xw
 * Date: 2018-08-10 14:24:58
 * Description: ParallaxLayoutInflater: .
 */
class ParallaxLayoutInflater constructor(inflater: LayoutInflater,
                                         context: Context?
) : LayoutInflater(inflater, context) {
    val factory: Factory2 = inflater.factory2

    init {
        factory2 = FactoryWrapper(this)
    }

    override fun cloneInContext(newContext: Context?): LayoutInflater {
        return ParallaxLayoutInflater(this, newContext)
    }

    private class FactoryWrapper(private val inflater: LayoutInflater) : Factory2 {

        private val sClassPrefixList = arrayOf(
                "android.widget.",
                "android.view.",
                "android.webkit."
        )

        override fun onCreateView(parent: View?, name: String, context: Context, attrs: AttributeSet): View? {
            return onCreateView(name, context, attrs)
        }

        override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
            var view: View? = null
            if (name.contains(".")) {
                view = crateView(name, null, attrs)
            } else {
                for (prefix in sClassPrefixList) {
                    view = crateView(name, prefix, attrs)
                    if (view != null) break
                }
            }
            return view
        }

        private fun crateView(name: String, prefix: String?, attrs: AttributeSet): View? {
            return try {
                inflater.createView(name, prefix, attrs)
            } catch (e: Exception) {
                null
            }
        }
    }
}