package com.example.motionlayoutplayground

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.motionlayoutplayground.utils.SimpleAdapter
import com.example.motionlayoutplayground.utils.addSpacing
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.layout_motion_toolbar.*

class BottomSheetActivity : AppCompatActivity() {
    var state = CLOSED

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

        recyclerView.adapter = SimpleAdapter()
        recyclerView.addSpacing()

        bottomSheet.bottomSheetRecycler.adapter = SimpleAdapter()
        bottomSheet.bottomSheetRecycler.addSpacing()

        val behavior = BottomSheetBehavior.from(bottomSheet)
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
}