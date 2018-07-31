package cn.xwj.metrialdesgintest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Author: xw
 * Date: 2018-07-31 16:47:30
 * Description: MyPagerFragmentAdapter: .
 */
class MyPagerFragmentAdapter(private val managerFragmentManager: FragmentManager)
    : FragmentPagerAdapter(managerFragmentManager) {

    private val title = arrayOf("头条", "新闻", "ABC", "地方", "杂志")

    override fun getItem(position: Int): Fragment {
        val fragment = NewsFragment()
        val bundle = Bundle()
        bundle.putString("text", title[position])
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int = title.size

    override fun getPageTitle(position: Int): CharSequence = title[position]
}