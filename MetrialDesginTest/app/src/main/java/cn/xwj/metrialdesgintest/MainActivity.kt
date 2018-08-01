package cn.xwj.metrialdesgintest

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transportStatus()
        mViewPager.adapter = MyPagerFragmentAdapter(supportFragmentManager)
        mTabLayout.setupWithViewPager(mViewPager)
    }

    private fun transportStatus() {

        val decorView = window.decorView
        if (Build.VERSION.SDK_INT > 21) {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN  or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }
}
