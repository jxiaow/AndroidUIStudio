package com.xw.tablayouttest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class NewsViewPager(private val fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val titleName = arrayOf(
            "头条",
            "新闻",
            "娱乐",
            "体育",
            "科技",
            "美女",
            "财经",
            "汽车",
            "房子",
            "头条"
    )


    override fun getItem(position: Int): Fragment {

        val fragment = NewsFragment()
        val bundle = Bundle()
        bundle.putString("title", getPageTitle(position).toString())
        fragment.arguments = bundle
        return fragment

    }

    override fun getCount(): Int = titleName.size

    override fun getPageTitle(position: Int): CharSequence? {
        return titleName[position]
    }
}