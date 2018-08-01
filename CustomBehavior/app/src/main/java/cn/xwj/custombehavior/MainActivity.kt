package cn.xwj.custombehavior

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun click(v: View) {
        ViewCompat.offsetTopAndBottom(v, 5)
    }

}
