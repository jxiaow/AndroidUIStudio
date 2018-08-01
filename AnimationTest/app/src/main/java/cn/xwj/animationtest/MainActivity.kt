package cn.xwj.animationtest

import android.animation.Animator
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var translate = 100f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mIV.setOnClickListener {
            //补间动画
//            val loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translation)
//            it.startAnimation(loadAnimation)

            //属性动画
//            translate += translate
//            val translationX = ObjectAnimator.ofFloat(it, "translationX", translate)
//            translationX.duration = 500
//            translationX.start()
//            val translationY = ObjectAnimator.ofFloat(it, "translationY", translate)
//            translationY.duration = 500
//            translationY.start()
//            val rotation = ObjectAnimator.ofFloat(it, "rotation", 180f)
//            rotation.duration = 500
//            rotation.start()

            val view = it
            val animator = ObjectAnimator.ofFloat(it, "alpha", 1f, 0f, 0.7f)
            animator.addUpdateListener {
                val value = it.animatedValue as Float
                view.scaleX = (100 + value) / 200
                view.scaleY = (100 + value) / 200
            }
            animator.addListener(object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            })
            animator.start()
        }
    }
}
