package cn.xwj.custombehavior

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.support.v4.widget.NestedScrollView
import android.util.AttributeSet
import android.view.View

/**
 * Author: xw
 * Date: 2018-08-01 16:01:06
 * Description: SyncScrollBehavior: .
 */
class SyncScrollBehavior @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null) :
        CoordinatorLayout.Behavior<NestedScrollView>() {

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: NestedScrollView,
                                     directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: NestedScrollView,
                                target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        child.scrollY = target.scrollY
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
    }

    override fun onNestedFling(coordinatorLayout: CoordinatorLayout, child: NestedScrollView, target: View,
                               velocityX: Float, velocityY: Float, consumed: Boolean): Boolean {
        child.fling(velocityY.toInt())
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed)
    }
}