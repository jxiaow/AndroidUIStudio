package cn.xwj.discrollview.view

import android.animation.ArgbEvaluator
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Author: xw
 * Date: 2018-08-09 16:19:57
 * Description: DiScrollableView: .
 */
class DiScrollableView @JvmOverloads constructor(context: Context,
                                                 attributeSet: AttributeSet? = null,
                                                 defStyle: Int = 0)
    : FrameLayout(context, attributeSet, defStyle), DiScrollableInterface {

    companion object {
        const val TRANSLATION_FROM_TOP = 0x01
        const val TRANSLATION_FROM_BOTTOM = 0x02
        const val TRANSLATION_FROM_LEFT = 0x04
        const val TRANSLATION_FROM_RIGHT = 0x08
    }

    var scrollFromBgColor: Int = -1//背景颜色变化开始值
    var scrollToBgColor: Int = -1//背景颜色变化结束值
    var scrollAlpha: Boolean = false//是否需要透明度动画
    var scrollTranslation: Int = -1//平移值
    var scrollScaleX: Boolean = false//是否需要x轴方向缩放
    var scrollScaleY: Boolean = false//是否需要y轴方向缩放

    private val argbEvaluator = ArgbEvaluator()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        onResetDiScroll()
    }


    override fun onDiScroll(ratio: Float) {
        startAnimation(ratio)
    }

    private fun startAnimation(ratio: Float) {
        if (scrollAlpha) {
            alpha = if (ratio > -1) ratio else 0f
        }

        if (scrollScaleX) {
            scaleX = if (ratio > -1) ratio else 0f
        }

        if (scrollScaleY) {
            scaleY = if (ratio > -1) ratio else 0f
        }

        if (ratio > -1 && scrollFromBgColor != -1 && scrollToBgColor != -1) {
            setBackgroundColor(argbEvaluator.evaluate(ratio, scrollFromBgColor, scrollToBgColor) as Int)
        }

        if (isTranslationFrom(TRANSLATION_FROM_BOTTOM)) {
            translationY = if (ratio > -1) height * (1 - ratio) else height.toFloat()
        }

        if (isTranslationFrom(TRANSLATION_FROM_TOP)) {
            translationY = if (ratio > -1) -height * (1 - ratio) else -height.toFloat()
        }

        if (isTranslationFrom(TRANSLATION_FROM_LEFT)) {
            translationX = if (ratio > -1) -width * (1 - ratio) else -width.toFloat()
        }

        if (isTranslationFrom(TRANSLATION_FROM_RIGHT)) {
            translationX = if (ratio > -1) width * (1 - ratio) else width.toFloat()
        }
    }

    private fun isTranslationFrom(translationMask: Int): Boolean = scrollTranslation == translationMask
            || scrollTranslation and translationMask == translationMask

    override fun onResetDiScroll() {
        startAnimation(-1f)
    }
}