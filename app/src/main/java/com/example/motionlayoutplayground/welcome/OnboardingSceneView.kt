package com.example.motionlayoutplayground.welcome

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.content_welcome.view.*

class OnboardingSceneView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr) {

    init {
        setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                title.text = when (p3) {
                    in 0f..0.25f -> "Welcome to Buildster"
                    in 0.25f..0.75f -> "Instantly Receive Updates"
                    else -> "Messaging"
                }
                message.text = when (p3) {
                    in 0f..0.25f -> "Visit the Projects screen to upload, share, and access building plans\n\nManage Tasks on the plans with team members\n\nCreate tasks for yourself and your team"
                    in 0.25f..0.75f -> "Post project updates or news to your team\n\nView, respond, and comment on open tasks\n\nSend realtime notifications to the team"
                    else -> "Keep your messages organized in each project\n\nHelps you connect with others in your projects\n\nEncourages growth"
                }
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
            }

        })
    }

    val pageListener = PageListener()

    inner class PageListener : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            val numPages = 3
            progress = (position + positionOffset) / (numPages - 1)
        }
    }
}