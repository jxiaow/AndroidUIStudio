package cn.xwj.dnparallaxsplash.widget

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Author: xw
 * Date: 2018-08-10 14:09:51
 * Description: ParallaxFragment: .
 */
class ParallaxFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val layoutId = arguments?.getInt("layoutId")

        layoutId?.let {
            ParallaxLayoutInflater(inflater, context).apply {
                return inflate(it, null)
            }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}