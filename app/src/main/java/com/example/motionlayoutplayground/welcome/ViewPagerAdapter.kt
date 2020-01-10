/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.motionlayoutplayground.welcome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutplayground.R

class ViewPagerAdapter() : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    val list = listOf("1", "2", "3")

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return (PagerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.background_pager,
                parent,
                false
            )
        ))
    }

    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}