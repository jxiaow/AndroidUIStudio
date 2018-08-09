package cn.xwj.discrollview.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import cn.xwj.discrollview.R

/**
 * Author: xw
 * Date: 2018-08-09 15:57:59
 * Description: DiScrollViewContent: .
 */
class DiScrollViewContent @JvmOverloads constructor(context: Context,
                                                    attributeSet: AttributeSet? = null,
                                                    defStyle: Int = 0)
    : LinearLayout(context, attributeSet, defStyle) {

    init {
        orientation = VERTICAL
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return DiScrollViewLayoutParams(context, attrs)
    }

    override fun addView(child: View, params: ViewGroup.LayoutParams) {

        if (params !is DiScrollViewLayoutParams || !isDiScrollable(params)) {
            super.addView(child, params)
            return
        }

        DiScrollableView(context).apply {
            scrollAlpha = params.mScrollAlpha
            scrollFromBgColor = params.mScrollFromBgColor
            scrollToBgColor = params.mScrollToBgColor
            scrollScaleX = params.mScrollScaleX
            scrollScaleY = params.mScrollScaleY
            scrollTranslation = params.mScrollTranslation
            this.addView(child, 0)
            super.addView(this, params)
        }

    }

    private fun isDiScrollable(params: DiScrollViewLayoutParams): Boolean {
        return with(params) {
            (mScrollFromBgColor != -1 && mScrollToBgColor != -1)
                    || mScrollAlpha
                    || mScrollScaleX
                    || mScrollScaleY
                    || mScrollTranslation != -1
        }
    }


    private class DiScrollViewLayoutParams @JvmOverloads constructor(context: Context,
                                                                     attributeSet: AttributeSet? = null)
        : LinearLayout.LayoutParams(context, attributeSet) {

        var mScrollFromBgColor: Int = -1//背景颜色变化开始值
        var mScrollToBgColor: Int = -1//背景颜色变化结束值
        var mScrollAlpha: Boolean = false//是否需要透明度动画
        var mScrollTranslation: Int = -1//平移值
        var mScrollScaleX: Boolean = false//是否需要x轴方向缩放
        var mScrollScaleY: Boolean = false//是否需要y轴方向缩放

        init {

            context.obtainStyledAttributes(attributeSet, R.styleable.DiScrollViewContent_Layout).apply {
                mScrollFromBgColor = getColor(R.styleable.DiScrollViewContent_Layout_scroll_fromBgColor, mScrollFromBgColor)
                mScrollToBgColor = getColor(R.styleable.DiScrollViewContent_Layout_scroll_toBgColor, mScrollToBgColor)
                mScrollAlpha = getBoolean(R.styleable.DiScrollViewContent_Layout_scroll_alpha, mScrollAlpha)
                mScrollTranslation = getInt(R.styleable.DiScrollViewContent_Layout_scroll_translation, mScrollTranslation)
                mScrollScaleX = getBoolean(R.styleable.DiScrollViewContent_Layout_scroll_scaleX, mScrollScaleX)
                mScrollScaleY = getBoolean(R.styleable.DiScrollViewContent_Layout_scroll_scaleY, mScrollScaleY)
                recycle()
            }
        }

    }
}