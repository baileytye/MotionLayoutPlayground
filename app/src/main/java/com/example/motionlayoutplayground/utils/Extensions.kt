package com.example.motionlayoutplayground.utils

import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutplayground.R

/**
 * Purpose: Adds vertical spacing above recycler items, or if a grid, add right spacing to even indexed items
 * Parameters: spacing - height between items, grid - true to use GridSpaceItemDecoration (add spacing to sides)
 * Requires:    GridSpaceItemDecoration.kt (found below), VerticalSpaceItemDecoration.kt (found below),
 *             default spacing declared as R.dimen.default_recycler_spacing in dimen
 * Usage: recyclerView.addSpacing(16) - Adds 16dp spacing for a linear list. Can be used like: recyclerView.addSpacing() if R.dimen.default_recycler_spacing is defined.
 *        To use a grid layout: recyclerView.addSpacing(16, true)
 * Source: Brain
 */
fun RecyclerView.addSpacing(
    spacing: Int = resources.getDimension(R.dimen.default_recycler_spacing).toInt(),
    grid: Boolean = false
) {
    addItemDecoration(
        if (grid) GridSpaceItemDecoration(spacing) else VerticalSpaceItemDecoration(
            spacing
        )
    )
}
