package cn.xwj.dnparallaxsplash.widget

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

/**
 * Author: xw
 * Date: 2018-08-10 14:38:28
 * Description: ParallaxExtensions: .
 */
fun Context.supportFragmentManager(): FragmentManager {
    return (this as FragmentActivity).supportFragmentManager
}