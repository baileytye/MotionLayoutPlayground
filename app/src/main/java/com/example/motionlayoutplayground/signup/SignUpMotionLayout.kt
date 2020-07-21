package com.example.motionlayoutplayground.signup

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager2.widget.ViewPager2


class SignUpMotionLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr) {

    val pageListener = PageListener()

    inner class PageListener : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            val numPages = 8
            progress = (position + positionOffset) / (numPages - 1)
        }
    }
}