package cn.xwj.animationtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        mIV.setOnClickListener {
//            //补间动画
////            val loadAnimation = AnimationUtils.loadAnimation(this, R.anim.set)
////            it.startAnimation(loadAnimation)
////            val view = it
////            val animation = ObjectAnimator.ofFloat(it, "scaleX", 1.0f, 0.5f, 0.7f)
////            animation.addUpdateListener({
////                view.scaleY = it.animatedValue.toString().toFloat()
////                Log.d("TAG", "animatedFraction: ${it.animatedFraction}, animatedValue: ${it.animatedValue} duration: ${it.duration}")
////            })
////            animation.start()
//
//
////            val translationX = PropertyValuesHolder.ofFloat("translationX", 0f, 200f)
////            val scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.5f, 0.7f)
////            val scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.5f, 0.7f)
////            val alpha = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.5f)
////
////            val valuesHolder = ObjectAnimator.ofPropertyValuesHolder(it, translationX, scaleX, scaleY, alpha)
////            valuesHolder.duration = 5000
////            valuesHolder.addUpdateListener {
////                Log.d("TAG", "animatedFraction: ${it.animatedFraction}, animatedValue: ${it.animatedValue} duration: ${it.duration}")
////            }
////            valuesHolder.start()
//
//
//            val translationX = ObjectAnimator.ofFloat(it, "translationX", 0f, 200f)
//            val scaleX = ObjectAnimator.ofFloat(it, "scaleX", 1.0f, 0.5f, 0.7f)
//            val scaleY = ObjectAnimator.ofFloat(it, "scaleY", 1.0f, 0.5f, 0.7f)
//            val alpha = ObjectAnimator.ofFloat(it, "alpha", 1.0f, 0.5f)
//
//            val animationSet = AnimatorSet()
//            animationSet.playTogether(translationX, scaleX, scaleY, alpha)
//            animationSet.duration = 5000
//            animationSet.start()
//
//
//        }
    }
}
