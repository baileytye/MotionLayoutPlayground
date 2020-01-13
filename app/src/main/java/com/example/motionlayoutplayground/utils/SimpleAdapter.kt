package com.example.motionlayoutplayground.utils

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutplayground.BottomSheetActivity
import com.example.motionlayoutplayground.R
import kotlinx.android.synthetic.main.item_test.view.*

class SimpleAdapter : RecyclerView.Adapter<SimpleViewHolder>() {
    private val items = listOf("Item 1", " Item 2", "Item 3", "Item 4", "Item 5")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_test,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.bind(items[position])
    }

}

class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: String) {
        itemView.text.text = item
        itemView.setOnClickListener {
            it.context.startActivity(Intent(it.context, BottomSheetActivity::class.java))
        }
    }
}