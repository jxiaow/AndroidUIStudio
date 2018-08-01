package cn.xwj.custombehavior

import android.animation.ObjectAnimator
import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * Author: xw
 * Date: 2018-08-01 14:14:23
 * Description: CustomBehavior: .
 */
class CustomBehavior @JvmOverloads constructor(context: Context,
                                               attributeSet: AttributeSet? = null)
    : CoordinatorLayout.Behavior<TextView>(context, attributeSet) {
    private val tag: String = "CustomBehavior"

    override fun layoutDependsOn(parent: CoordinatorLayout, child: TextView,
                                 dependency: View): Boolean {
        Log.d(tag, "child: $child ---->  dependency: $dependency")
        return dependency is Button || super.layoutDependsOn(parent, child, dependency)
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: TextView,
                                        dependency: View): Boolean {
        val offset = dependency.top - child.top
        if(offset > 0){

            ViewCompat.offsetTopAndBottom(child, offset)
            val animator = ObjectAnimator.ofFloat(child, "rotation", -180f, 180f)
            animator.duration = 500
            animator.start()
        }
        return super.onDependentViewChanged(parent, child, dependency)
    }

}