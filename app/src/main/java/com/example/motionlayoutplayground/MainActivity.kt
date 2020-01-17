package com.example.motionlayoutplayground

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayoutplayground.utils.SimpleAdapter
import com.example.motionlayoutplayground.utils.addSpacing
import kotlinx.android.synthetic.main.activity_main.*


const val CLOSED = 0
const val OPEN = 1

class MainActivity : AppCompatActivity() {

    var state = CLOSED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonClose2.setOnClickListener {
            if (state == OPEN) {
                content.transitionToStart()
                state = CLOSED
            }
        }
        buttonSearch2.setOnClickListener {
            if (state == CLOSED) {
                content.transitionToEnd()
                state = OPEN
            }
        }

        recyclerView.adapter = SimpleAdapter {
            startActivity(Intent(this, BottomSheetActivity::class.java))
        }
        recyclerView.addSpacing()
    }

}
