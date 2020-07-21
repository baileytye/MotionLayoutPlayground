package com.example.motionlayoutplayground.signup

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class FadePageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.setAlpha(0f)
        page.setVisibility(View.VISIBLE)

        // Start Animation for a short period of time
        page.animate()
            .alpha(1f)
            .setDuration(300)
    }
}