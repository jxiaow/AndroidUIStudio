package cn.xwj.fabtest

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity1 : AppCompatActivity(), HideListener {
    override fun onHide() {
        val layoutParams = mFAB.layoutParams as RelativeLayout.LayoutParams
        mFAB.animate()
                .translationY((mFAB.height + layoutParams.bottomMargin).toFloat())
                .interpolator = AccelerateInterpolator()

        mToolbar.animate().translationY(-mToolbar.height.toFloat())
                .interpolator = AccelerateInterpolator()

    }

    override fun onShow() {

        mFAB.animate()
                .translationY(0f)
                .interpolator = DecelerateInterpolator()
        mToolbar.animate().translationY(0f)
                .interpolator = DecelerateInterpolator()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = MyRecyclerViewAdapter(this)

        mFAB.setOnClickListener {
            Snackbar.make(it, "fab的点击事件", Snackbar.LENGTH_LONG).show()
        }
        mRecyclerView.addOnScrollListener(MyScrollListener(this))
    }
}
