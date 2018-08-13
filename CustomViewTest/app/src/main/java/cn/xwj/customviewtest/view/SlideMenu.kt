package cn.xwj.customviewtest.view

import android.content.Context
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.HorizontalScrollView


/**
 * Author: xw
 * Date: 2018-08-13 14:09:32
 * Description: SlideMenu: .
 */
class SlideMenu @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : HorizontalScrollView(context, attrs, defStyleAttr) {
    private val mScreenWidth: Int
    private var mMenu: ViewGroup? = null
    private var mContent: ViewGroup? = null
    private val mMenuPaddingRight: Int = 100
    private var isOnce = false
    private var mMenuWidth: Int = 0
    private var downX: Float = 0.0f

    init {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(outMetrics)
        mScreenWidth = outMetrics.widthPixels
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (!isOnce) {
            val viewGroup = getChildAt(0) as ViewGroup
            mMenu = viewGroup.getChildAt(0) as ViewGroup?
            mContent = viewGroup.getChildAt(1) as ViewGroup?
            mMenuWidth = mScreenWidth - mMenuPaddingRight
            mMenu?.layoutParams?.width = mMenuWidth
            mContent?.layoutParams?.width = mScreenWidth
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        if (changed) {
            isOnce = true
        }
        super.onLayout(changed, l, t, r, b)
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {

        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = ev.x
            }
            MotionEvent.ACTION_UP -> {
                val dx = ev.x - downX
                if (dx < mScreenWidth / 3) {
                    smoothScrollTo(mMenuWidth, 0)
                } else {
                    smoothScrollTo(0, 0)
                }
                return true
            }
        }
        return super.onTouchEvent(ev)
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)

        val factor = l.toFloat() / mMenuWidth
        val leftScale = 1 - factor * 0.4f
        val rightScale = 0.8f + 0.2f * factor


        mMenu?.let {
            it.translationX = mMenuWidth * factor * 0.6f
            it.scaleX = leftScale
            it.scaleY = leftScale
            it.alpha = 1 - factor
        }

        mContent?.let {
            it.scaleX = rightScale
            it.scaleY = rightScale
        }
    }
}