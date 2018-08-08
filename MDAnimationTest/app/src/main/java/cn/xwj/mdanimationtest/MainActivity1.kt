package cn.xwj.mdanimationtest

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mBtn1.setOnClickListener {
//
//            if (Build.VERSION.SDK_INT >= 21) { //揭露效果
//                val circularReveal = ViewAnimationUtils.createCircularReveal(it,
//                        it.width / 2, it.height / 2, 0f, it.height.toFloat())
//                circularReveal.duration = 200
//                circularReveal.interpolator = AccelerateInterpolator()
//                circularReveal.start()
//            }
//        }
//
//        mBtn2.setOnClickListener {
//            if (Build.VERSION.SDK_INT >= 21) {
//                val circularReveal = ViewAnimationUtils.createCircularReveal(it, 0,
//                        0, 0f, Math.hypot(it.width / 2.0, it.height / 2.0).toFloat())
//                circularReveal.duration = 200
//                circularReveal.interpolator = AccelerateInterpolator()
//                circularReveal.start()
//            }
//        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
