package cn.xwj.fabtest

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_layout.view.*

/**
 * Author: xw
 * Date: 2018-07-31 14:32:47
 * Description: MyRecyclerViewAdapter: .
 */
class MyRecyclerViewAdapter(private val context: Context) :
        RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    private val dataList = mutableListOf<String>()

    init {
        for (i in 0..30) {
            dataList.add("$i")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.mTV.text = dataList[position]
    }


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}