package cn.xwj.animationtest

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mBtn.setOnClickListener {

            /**
             * 1）first_View动画：1.翻转动画；2.透明度动画；3.缩放动画
             */

            val firstRotation = ObjectAnimator.ofFloat(mFirstView, "rotationX", 0f, 25f)
            firstRotation.duration = 300


            val firstAlpha = ObjectAnimator.ofFloat(mFirstView, "alpha", 1.0f, 0.8f)
            firstAlpha.duration = 200


            val firstScaleX = ObjectAnimator.ofFloat(mFirstView, "scaleX", 1.0f, 0.8f)
            firstScaleX.duration = 300
            val firstScaleY = ObjectAnimator.ofFloat(mFirstView, "scaleY", 1.0f, 0.8f)
            firstScaleY.duration = 300

            val firstRotationResume = ObjectAnimator.ofFloat(mFirstView, "rotationX", 25f, 0f)
            firstRotationResume.duration = 200
            firstRotationResume.startDelay = 200


            val firstTranslationY = ObjectAnimator.ofFloat(mFirstView, "translationY", 0f, -0.1f * mFirstView.height)
            firstTranslationY.duration = 200




            val animatorSet = AnimatorSet()
            animatorSet.playTogether(firstRotation, firstAlpha, firstScaleX, firstScaleY, firstRotationResume, firstTranslationY)
            animatorSet.start()
        }
    }
}
