package com.example.motionlayoutplayground

import android.animation.LayoutTransition
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.motionlayoutplayground.utils.SimpleAdapter
import com.example.motionlayoutplayground.utils.addSpacing
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_motion_toolbar.*


const val CLOSED = 0
const val OPEN = 1

class MainActivity : AppCompatActivity() {

    var state = CLOSED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        linearLayout.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        buttonClose.setOnClickListener {
            if (state == OPEN) {
                //Not required but incase there are multiple transitions
                (includeMotionLayout as MotionLayout).setTransition(R.id.start, R.id.search)
                (includeMotionLayout as MotionLayout).progress = 1f //setTransition resets progress
                (includeMotionLayout as MotionLayout).transitionToStart()
                state = CLOSED
            }
        }
        buttonSearch.setOnClickListener {
            if (state == CLOSED) {
                (includeMotionLayout as MotionLayout).setTransition(R.id.start, R.id.search)
                (includeMotionLayout as MotionLayout).transitionToEnd()
                state = OPEN
            }
        }

        recyclerView.adapter = SimpleAdapter()
        recyclerView.addSpacing()
    }

}
