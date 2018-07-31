package cn.xwj.fabtest

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Author: xw
 * Date: 2018-07-31 15:43:25
 * Description: CustomBehavior: .
 */
class CustomBehavior @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null)
    : FloatingActionButton.Behavior(context, attributeSet) {
    private val tag = "CustomBehavior"
    private var visible = true

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                     directTargetChild: View, target: View, axes: Int, type: Int): Boolean {

        Log.d(tag, "onStartNestedScroll")
        // 当观察的View（RecyclerView）发生滑动的开始的时候回调的
        //nestedScrollAxes:滑动关联轴， 我们现在只关心垂直的滑动。
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL ||
                super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }


    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int,
                                dyUnconsumed: Int, type: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed,
                dyConsumed, dxUnconsumed, dyUnconsumed, type)
        Log.d(tag, "onNestedScroll")

        if (dyConsumed > 0 && visible) {
            onHide(child)
            visible = false
        } else if (dyConsumed < 0) {
            onShow(child)
            visible = true
        }
    }



    private fun onShow(child: FloatingActionButton) {
        ViewCompat.animate(child).scaleX(1f).scaleY(1f).start()
    }

    private fun onHide(child: FloatingActionButton) {
        ViewCompat.animate(child).scaleX(0f).scaleY(0f).start()
    }


}