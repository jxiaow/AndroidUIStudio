package com.xw.palatedesign

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawable: BitmapDrawable = mImageView.drawable as BitmapDrawable
        Palette.from(drawable.bitmap)
                .generate {
                    //暗柔和色
                    val darkMutedColor = it.getDarkMutedColor(Color.BLUE)
                    //暗鲜明色
                    val darkVibrantColor = it.getDarkVibrantColor(Color.BLUE)
                    //主色
                    val dominantColor = it.getDominantColor(Color.BLUE)
                    //亮柔和色
                    val lightMutedColor = it.getLightMutedColor(Color.BLUE)
                    // 亮鲜明色
                    val lightVibrantColor = it.getLightVibrantColor(Color.BLUE)
                    //柔和色
                    val mutedColor = it.getMutedColor(Color.BLUE)
                    //鲜明色
                    val vibrantColor = it.getVibrantColor(Color.BLUE)

                    mTv1.setBackgroundColor(darkMutedColor)
                    mTv1.text = "darkMutedColor"
                    mTv2.setBackgroundColor(darkVibrantColor)
                    mTv2.text = "darkVibrantColor"
                    mTv3.setBackgroundColor(lightMutedColor)
                    mTv3.text = "lightMutedColor"
                    mTv4.setBackgroundColor(dominantColor)
                    mTv4.text = "dominantColor"
                    mTv5.setBackgroundColor(lightVibrantColor)
                    mTv5.text = "lightVibrantColor"
                    mTv6.setBackgroundColor(mutedColor)
                    mTv6.text = "mutedColor"
                    mTv7.setBackgroundColor(vibrantColor)
                    mTv7.text = "vibrantColor"


                    val vibrantSwatch = it.vibrantSwatch
                    vibrantSwatch?.let {
                        val rgb = it.rgb
                        val bodyTextColor = it.bodyTextColor
                        Log.d("TAG", "rgb: $rgb")
                        mDescText.setBackgroundColor(getTranslucentColor(0.6f, rgb))
                        mDescText.setTextColor(bodyTextColor)
                    }
                }
    }

    private fun getTranslucentColor(rate: Float, rgb: Int): Int {
        val blue = rgb and 0xff
        val green = rgb shr 8 and 0xff
        val red = rgb shr 16 and 0xff
        var alpha = rgb ushr 24 and 0xff

        alpha = (alpha * rate).roundToInt()

        val color = Color.argb(alpha, red, green, blue)
        Log.d("TAG", "color: $color")
        return color
    }
}
