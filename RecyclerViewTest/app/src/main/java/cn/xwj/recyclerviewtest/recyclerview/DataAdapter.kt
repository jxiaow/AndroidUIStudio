package cn.xwj.recyclerviewtest.recyclerview

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.TextView

/**
 * Author: xw
 * Date: 2018-07-16 09:56:23
 * Description: DataAdapter: .
 */
class DataAdapter(private val context: Context, private val dataList: MutableList<String>)
    : RecyclerView.Adapter<DataAdapter.ViewHolder>(), ItemTouchListener {

    override fun swipe(adapterPosition: Int) {
        notifyItemRemoved(adapterPosition)
    }

    private var startDrag: ((viewHolder: ViewHolder) -> Unit)? = null

    override fun move(srcPosition: Int, targetPosition: Int) {
        notifyItemMoved(srcPosition, targetPosition)
    }

    fun startDrag(listener: (viewHolder: ViewHolder) -> Unit) {
        this.startDrag = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val tv = TextView(context)
        val layoutParams: FrameLayout.LayoutParams = FrameLayout.LayoutParams(MATCH_PARENT, 100)
        with(layoutParams) {
            bottomMargin = 5
            leftMargin = 5
            rightMargin = 5
        }

        with(tv) {
            this.layoutParams = layoutParams
            gravity = Gravity.CENTER
            setPadding(5, 0, 5, 5)
            setBackgroundColor(Color.GRAY)
        }

        return ViewHolder(tv)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.itemView as TextView
        textView.text = dataList[position]
        startDrag?.invoke(holder)
    }

    fun insertItem(position: Int) {
        dataList.add(position, "新增条目$position")
        notifyItemInserted(position)
    }


    class ViewHolder(textView: View) : RecyclerView.ViewHolder(textView)
}