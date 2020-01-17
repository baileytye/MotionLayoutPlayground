package com.example.motionlayoutplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionlayoutplayground.utils.SimpleAdapter
import com.example.motionlayoutplayground.utils.addSpacing
import kotlinx.android.synthetic.main.fragment_bottom_sheet1.*

class BottomSheetFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bottomSheetRecycler.adapter = SimpleAdapter {

        }
        bottomSheetRecycler.addSpacing()
    }
}