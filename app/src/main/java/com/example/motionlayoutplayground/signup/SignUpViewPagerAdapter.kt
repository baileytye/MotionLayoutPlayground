package com.example.motionlayoutplayground.signup

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SignUpViewPagerAdapter(parent: Fragment) : FragmentStateAdapter(parent) {
    override fun getItemCount(): Int {
        return 8
    }

    override fun createFragment(position: Int): Fragment {
        return SignUp1Fragment()
    }
}