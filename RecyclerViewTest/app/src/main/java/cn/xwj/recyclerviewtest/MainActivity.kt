package cn.xwj.recyclerviewtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import cn.xwj.recyclerviewtest.recyclerview.DataAdapter
import cn.xwj.recyclerviewtest.recyclerview.DividerItemDecoration
import cn.xwj.recyclerviewtest.recyclerview.DividerItemDecoration.Companion.VERTICAL
import cn.xwj.recyclerviewtest.recyclerview.ItemTouchCallBack
import cn.xwj.recyclerviewtest.util.DataUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: DataAdapter
    private lateinit var mDividerDirection: DividerItemDecoration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

        mBtnSwitch.setOnClickListener(this::click)
        mBtnAdd.setOnClickListener(this::click)

    }

    private fun click(view: View) {
        when (view.id) {
            R.id.mBtnAdd -> {
                adapter.insertItem(0)
                mRecyclerView.smoothScrollToPosition(0)
            }
            R.id.mBtnSwitch -> {
                mRecyclerView.removeItemDecoration(mDividerDirection)
                if (mRecyclerView.layoutManager is GridLayoutManager) {
                    mDividerDirection = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
                    val layoutManager = LinearLayoutManager(this)
                    layoutManager.orientation = LinearLayoutManager.VERTICAL
                    mRecyclerView.layoutManager = layoutManager
                    mRecyclerView.addItemDecoration(mDividerDirection)

                } else {
                    mRecyclerView.layoutManager = GridLayoutManager(this, 3)
                }
            }
        }
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.itemAnimator = DefaultItemAnimator()
        mDividerDirection = DividerItemDecoration(this, VERTICAL)
        mRecyclerView.addItemDecoration(mDividerDirection)

        adapter = DataAdapter(this, DataUtil.init())
        mRecyclerView.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(ItemTouchCallBack(adapter))
        itemTouchHelper.attachToRecyclerView(mRecyclerView)
        adapter.startDrag {
            itemTouchHelper.startDrag(it)
        }
    }
}
