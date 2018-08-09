package cn.xwj.discrollview.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ScrollView

/**
 * Author: xw
 * Date: 2018-08-09 15:53:29
 * Description: DiScrollView: .
 */

class DiScrollView @JvmOverloads constructor(context: Context,
                                             attributeSet: AttributeSet? = null,
                                             defStyle: Int = 0)
    : ScrollView(context, attributeSet, defStyle) {

    private var mContent: DiScrollViewContent? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        mContent = getChildAt(0) as? DiScrollViewContent
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        getChildAt(0).layoutParams.height = height
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)

        val scrollViewHeight = height

        mContent?.let {

            for (i in 0 until it.childCount) {
                val child = it.getChildAt(i)
                if (child is DiScrollableInterface) {

                    val childTop = child.top
                    val childHeight = child.height

                    val absTop = childTop - t

                    if (absTop <= scrollViewHeight) {
                        val snap = scrollViewHeight - absTop
                        child.onDiScroll(clamp(snap / childHeight.toFloat(), 0f, 1f))
                    } else {
                        child.onResetDiScroll()
                    }
                }
            }
        }
    }

    private fun clamp(value: Float, min: Float, max: Float): Float {
        return Math.max(Math.min(value, max), min)
    }
}