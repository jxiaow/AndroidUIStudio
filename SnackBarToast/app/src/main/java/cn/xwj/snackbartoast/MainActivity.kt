package cn.xwj.snackbartoast

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mToastBtn.setOnClickListener(this::click)
        mSnackBtn.setOnClickListener(this::click)
    }

    private fun click(v: View) {
        when (v.id) {
            R.id.mToastBtn -> customView()
            R.id.mSnackBtn -> {
                Snackbar.make(v, "你使用的是SnackBar", Snackbar.LENGTH_LONG).setAction("确定") {
                    customView()
                }.show()
            }
        }
    }

    /**
     * 自定义吐司
     */
    private fun customView() {
        val toast = Toast(this)
        val inflater: LayoutInflater = LayoutInflater.from(this)
        val view = inflater.inflate(R.layout.custom_view, null)
        toast.view = view
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }
}
