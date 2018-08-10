package cn.xwj.dnparallaxsplash.widget

import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import cn.xwj.dnparallaxsplash.R

/**
 * Author: xw
 * Date: 2018-08-10 11:39:08
 * Description: ParallaxContainer: .
 */
class ParallaxContainer @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val mViewPager: ViewPager
    private val mParallaxAdapter: ParallaxContainerAdapter
    private val mFragmentList: MutableList<ParallaxFragment> = mutableListOf()

    init {
        mParallaxAdapter = ParallaxContainerAdapter(context.supportFragmentManager(), mFragmentList)
        mViewPager = ViewPager(context).apply {
            id = R.id.parallax_container
            adapter = mParallaxAdapter
            layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }
        addView(mViewPager, 0)
    }


    fun setUp(@LayoutRes vararg layoutResId: Int) {

        mFragmentList.clear()
        for (layoutRes in layoutResId) {
            val fragment = ParallaxFragment()
            val bundle = Bundle()
            bundle.putInt("layoutId", layoutRes)
            fragment.arguments = bundle
            mFragmentList.add(fragment)
        }
        mParallaxAdapter.notifyDataSetChanged()
    }

}