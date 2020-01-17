package com.example.motionlayoutplayground

import android.animation.ObjectAnimator
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.animation.doOnEnd
import com.example.motionlayoutplayground.utils.SimpleAdapter
import com.example.motionlayoutplayground.utils.addSpacing
import com.example.motionlayoutplayground.utils.replaceFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.android.synthetic.main.bottom_sheet_container.*
import kotlinx.android.synthetic.main.layout_motion_toolbar.*

class BottomSheetActivity : AppCompatActivity() {
    var state = CLOSED
    val fragment1 = BottomSheetFragment1()
    val fragment2 = BottomSheetFragment2()
    var isFragment1 = true
    val behavior by lazy { BottomSheetBehavior.from(bottomSheet) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        buttonClose.setOnClickListener {
            if (state == OPEN) {
                (includeMotionLayout as MotionLayout).transitionToStart()
                state = CLOSED
            }
        }
        buttonSearch.setOnClickListener {
            if (state == CLOSED) {
                (includeMotionLayout as MotionLayout).transitionToEnd()
                state = OPEN
            }
        }

        recyclerView.adapter = SimpleAdapter {
            animateHideBottomSheet()
        }
        recyclerView.addSpacing()
        view.visibility = View.GONE

        replaceFragment(fragment1, R.id.fragmentContainer)

        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                val background = bottomSheet.background as GradientDrawable
                background.cornerRadius =
                    (1 - slideOffset) * bottomSheet.resources.getDimension(R.dimen.bottom_sheet_radius)
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }

        })
    }

    private fun animateHideBottomSheet() {
        val height =
            resources.getDimension(R.dimen.bottom_sheet_peek_height).toInt() * (if (isFragment1) 1 else 2)
        val animator = ObjectAnimator.ofInt(height, 0).apply {
            duration = 150
            addUpdateListener {
                behavior.peekHeight = it.animatedValue as Int
            }
            doOnEnd {
                replaceFragment(if (isFragment1) fragment2 else fragment1, R.id.fragmentContainer)
                animateShowBottomSheet()
                isFragment1 = isFragment1.not()
            }
        }
        animator.start()
    }

    private fun animateShowBottomSheet() {
        val height =
            resources.getDimension(R.dimen.bottom_sheet_peek_height).toInt() * (if (isFragment1) 2 else 1)
        val animator = ObjectAnimator.ofInt(0, height).apply {
            duration = 150
            addUpdateListener {
                behavior.peekHeight = it.animatedValue as Int
            }
        }
        animator.start()
        if (isFragment1) {
            view.visibility = View.VISIBLE
            ObjectAnimator.ofFloat(view, View.ALPHA, 0f, 1f).apply {
                start()
            }

        } else {
            ObjectAnimator.ofFloat(view, View.ALPHA, 1f, 0f).apply {
                duration = 100
                doOnEnd {
                    view.visibility = View.GONE
                }
                start()
            }
        }
    }
}