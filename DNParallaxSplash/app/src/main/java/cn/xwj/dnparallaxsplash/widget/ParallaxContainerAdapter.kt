package cn.xwj.dnparallaxsplash.widget

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Author: xw
 * Date: 2018-08-10 11:49:45
 * Description: ParallaxContainerAdapter: .
 */
class ParallaxContainerAdapter(fm: FragmentManager,
                               private val fragmentList: MutableList<ParallaxFragment>
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = fragmentList[position]


    override fun getCount(): Int = fragmentList.size


}