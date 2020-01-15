package com.example.motionlayoutplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_header.*
import kotlinx.android.synthetic.main.layout_motion_toolbar.*

class HeaderActivity : AppCompatActivity() {

    var state = CLOSED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_header)


        (includeHeader as MotionLayout).let { motion ->
            motion.setTransitionListener(object : MotionLayout.TransitionListener {
                override fun onTransitionTrigger(
                    p0: MotionLayout?,
                    p1: Int,
                    p2: Boolean,
                    p3: Float
                ) {
                }

                override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                }

                override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                }

                override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                    if (p1 == R.id.start) {
                        motion.setTransition(R.id.start, R.id.end)
                    }
                }

            })

            buttonClose.setOnClickListener {
                if (state == OPEN) {
                    //Not required but incase there are multiple transitions
                    (includeHeader as MotionLayout).setTransition(R.id.start, R.id.search)
                    (includeHeader as MotionLayout).progress = 1f //setTransition resets progress
                    (includeHeader as MotionLayout).transitionToStart()
                    state = CLOSED
                }
            }
            buttonSearch.setOnClickListener {
                if (state == CLOSED) {
                    (includeHeader as MotionLayout).setTransition(R.id.start, R.id.search)
                    (includeHeader as MotionLayout).transitionToEnd()
                    state = OPEN
                }
            }

//            includeHeader.title.setOnClickListener {
//                if(motion.currentState == R.id.gone){
//                    motion.transitionToStart()
//                }
//                else {
//                    motion.setTransition(R.id.start, R.id.gone)
//                    motion.transitionToEnd()
//                }
//            }
        }

        (motionActivity as MotionLayout).setTransitionListener(
            object : MotionLayout.TransitionListener {
                var valid = true

                override fun onTransitionTrigger(
                    p0: MotionLayout?,
                    p1: Int,
                    p2: Boolean,
                    p3: Float
                ) {
                }

                override fun onTransitionStarted(p0: MotionLayout, p1: Int, p2: Int) {
                    (includeHeader as MotionLayout).let {
                        valid = it.endState == R.id.end
                        println("DEBUG: valid: $valid")
                    }
                }

                override fun onTransitionChange(p0: MotionLayout, p1: Int, p2: Int, p3: Float) {
                    (includeHeader as MotionLayout).let {
                        println("DEBUG: valid: $valid")
                        if (valid)
                            it.progress = p3
                    }

                }

                override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                }

            }
        )
    }
}