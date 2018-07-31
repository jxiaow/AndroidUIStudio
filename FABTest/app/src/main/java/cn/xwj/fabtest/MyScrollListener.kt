package cn.xwj.fabtest

import android.support.v7.widget.RecyclerView

/**
 * Author: xw
 * Date: 2018-07-31 14:55:22
 * Description: MyScrollListener: .
 */
class MyScrollListener(private val listener: HideListener) : RecyclerView.OnScrollListener() {
    private val threshold = 20
    private var distance = 0
    private var visiable = true


    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (distance > threshold && visiable) {
            listener.onHide()
            visiable = false
            distance = 0
        } else if (distance < -threshold && !visiable) {
            listener.onShow()
            visiable = true
            distance = 0
        }

        if (visiable && dy > 0 || (!visiable && dy < 0)){
            distance += dy
        }
    }
}