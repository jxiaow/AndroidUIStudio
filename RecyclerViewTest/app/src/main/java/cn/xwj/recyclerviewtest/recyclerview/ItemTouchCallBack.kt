package cn.xwj.recyclerviewtest.recyclerview

import android.graphics.Canvas
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import cn.xwj.recyclerviewtest.safeCall
import kotlin.math.absoluteValue

/**
 * Author: xw
 * Date: 2018-07-16 16:36:38
 * Description: ItemTouchCallBack: .
 */
class ItemTouchCallBack(private val listener: ItemTouchListener) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {

        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(recyclerView: RecyclerView?, src: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {

        if (src != null && target != null) {
            listener.move(src.adapterPosition, target.adapterPosition)
        }
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        viewHolder?.let {
            listener.swipe(it.adapterPosition)
        }
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        viewHolder.safeCall {
            itemView.setBackgroundColor(Color.RED)
        }
        super.onSelectedChanged(viewHolder, actionState)
    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?,
                             dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        viewHolder.safeCall {
            if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                if (dX.absoluteValue <= itemView.width / 2) {
                    val alpha = 1 - dX.absoluteValue / itemView.width
                    itemView.scaleX = alpha
                    itemView.scaleY = alpha
                    itemView.alpha = alpha
                    itemView.translationX = -0.5f*itemView.width
                } else {
                    itemView.scaleX = 1f
                    itemView.scaleY = 1f
                    itemView.alpha = 1f
                    itemView.translationX = dX
                }
            }
        }
//        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    override fun clearView(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?) {

        viewHolder.safeCall {
            itemView.scaleX = 1f
            itemView.scaleY = 1f
            itemView.alpha = 1f
            itemView.setBackgroundColor(Color.GRAY)
        }

        super.clearView(recyclerView, viewHolder)
    }

    override fun isLongPressDragEnabled(): Boolean = true
}
