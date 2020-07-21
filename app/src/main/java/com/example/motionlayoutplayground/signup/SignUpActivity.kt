package com.example.motionlayoutplayground.signup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayoutplayground.R

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SignUpFragment::class.java, null)
                .commitNow()
        }
    }
}