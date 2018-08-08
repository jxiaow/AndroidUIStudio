package cn.xwj.mdanimationtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_second)

        mBtn1.setOnClickListener { onBackPressed() }
    }
}
