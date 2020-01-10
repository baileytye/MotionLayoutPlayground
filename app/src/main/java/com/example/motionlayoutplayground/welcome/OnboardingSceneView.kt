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

    val pageListener = PageListener()

    inner class PageListener : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            val numPages = 3
            progress = (position + positionOffset) / (numPages - 1)

            when (position) {
                0 -> {
                    title.text = "Welcome to Buildster"
                    message.text =
                        "Visit the Projects screen to upload, share, and access building plans\n\nManage Tasks on the plans with team members\n\nCreate tasks for yourself and your team"
                }
                1 -> {
                    title.text = "Instantly Receive Updates"
                    message.text =
                        "Post project updates or news to your team\n\nView, respond, and comment on open tasks\n\nSend realtime notifications to the team"
                }
                2 -> {
                    title.text = "Messaging"
                    message.text =
                        "Keep your messages organized in each project\n\nHelps you connect with others in your projects\n\nEncourages growth"
                }
            }
        }
    }
}