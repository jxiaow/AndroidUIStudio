package cn.xwj.recyclerviewtest.recyclerview

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.annotation.IntDef
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import kotlin.math.roundToInt

/**
 * Author: xw
 * Date: 2018-07-16 14:17:10
 * Description: DividerItemDecoration: .
 */
class DividerItemDecoration(context: Context, @Orientation private var orientation: Int = VERTICAL)
    : RecyclerView.ItemDecoration() {

    private val attrs: IntArray = intArrayOf(android.R.attr.listDivider)
    private var mDivider: Drawable? = null
    private val mRect: Rect = Rect()

    init {
        val typedArray: TypedArray = context.obtainStyledAttributes(attrs)
        mDivider = typedArray.getDrawable(0)
        typedArray.recycle()
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        if (mDivider == null) {
            super.onDraw(c, parent, state)
            return
        }

        if (orientation == VERTICAL) drawVertical(c, parent)
        else drawHorizontal(c, parent)

    }

    private fun drawHorizontal(c: Canvas, parent: RecyclerView) {
        c.save()
        val top: Int
        val bottom: Int
        if (parent.clipToPadding) {
            top = parent.paddingTop
            bottom = parent.height - parent.paddingBottom
            c.clipRect(parent.paddingLeft, top, parent.width - parent.paddingRight, bottom)
        } else {
            top = 0
            bottom = parent.height
        }

        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            parent.getDecoratedBoundsWithMargins(view, mRect)
            val right = mRect.right - view.paddingRight
            val left = right - view.translationX.roundToInt()

            mDivider!!.setBounds(left, top, right, bottom)
            mDivider!!.draw(c)
        }

        c.restore()

    }

    private fun drawVertical(c: Canvas, parent: RecyclerView) {
        c.save()
        val left: Int
        val right: Int
        if (parent.clipToPadding) {
            left = parent.paddingLeft
            right = parent.width - parent.paddingRight
            c.clipRect(left, parent.paddingTop, right, parent.height - parent.paddingBottom)
        } else {
            left = 0
            right = parent.width
        }

        for (i in 0 until parent.childCount) {

            val view = parent.getChildAt(i)
            val layoutParams: RecyclerView.LayoutParams = view.layoutParams as RecyclerView.LayoutParams
            parent.getDecoratedBoundsWithMargins(view, mRect)
            val bottom = mRect.bottom - view.paddingBottom / 2 - view.translationY.roundToInt()
            val top = bottom - mDivider!!.intrinsicHeight

            mDivider!!.setBounds(left + layoutParams.leftMargin, top, right - layoutParams.rightMargin, bottom)
            mDivider!!.draw(c)
        }

        c.restore()
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State) {
        if (mDivider == null) {
            outRect.set(0, 0, 0, 0)
            return
        }

        mDivider?.let {
            if (orientation == VERTICAL) outRect.set(0, 0, 0, it.intrinsicHeight)
            else outRect.set(0, 0, it.intrinsicWidth, 0)
        }

    }

    fun setOrientation(@Orientation orientation: Int) {
        this.orientation = orientation
    }

    companion object {
        const val VERTICAL: Int = LinearLayout.VERTICAL
        const val HORIZONTAL: Int = LinearLayout.HORIZONTAL
    }

    @IntDef(VERTICAL, HORIZONTAL)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Orientation

}