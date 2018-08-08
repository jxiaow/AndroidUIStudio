package cn.xwj.mdanimationtest

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtn1.setOnClickListener {
            val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, mIV, "iv_meinv3")
            val intent = Intent(this, SecondActivity::class.java)
            if (Build.VERSION.SDK_INT >= 16) {
                startActivity(intent, optionsCompat.toBundle())
            } else {
                startActivity(intent)
            }


        }

    }
}
