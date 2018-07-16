package cn.xwj.recyclerviewtest.recyclerview

/**
 * Author: xw
 * Date: 2018-07-16 16:39:04
 * Description: ItemTouchListener: .
 */
interface ItemTouchListener {
    fun move(srcPosition: Int, targetPosition: Int)
    fun swipe(adapterPosition: Int)
}