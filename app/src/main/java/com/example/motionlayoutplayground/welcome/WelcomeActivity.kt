package com.example.motionlayoutplayground.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayoutplayground.MainActivity
import com.example.motionlayoutplayground.R
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.android.synthetic.main.content_welcome.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val adapter = ViewPagerAdapter()
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(motionLayout.pageListener)
        buttonSkip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        buttonNext.setOnClickListener {
            if (viewPager.currentItem == 2) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else viewPager.currentItem += 1
        }
    }
}