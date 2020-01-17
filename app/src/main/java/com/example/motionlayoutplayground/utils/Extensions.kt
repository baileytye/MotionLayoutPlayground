package com.example.motionlayoutplayground.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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

/**
 * Purpose: Start an activity with optional parameters for flags, options
 * Parameters:  extras [Optional] - extras to send to next activity
 *              flags [Optional] - activity flags
 *              options [Optional] - activity options
 * Requires: Intent extension Intent.withExtras
 * Usage:   startActivityWithClass<NEXTACTIVITY>()
 *          startActivityWithClass<NEXTACTIVITY>(flags = Intent.FLAG)
 *          startActivityWithClass<NEXTACTIVITY>(EXTRA_A to MyParceableClassA, EXTRA_B to MyInt, EXTRA_C to MyBoolean, options = XX)
 * Source: Brain/Medium Article which I can't find
 * Notes: Use all the time
 */
inline fun <reified T : Activity> AppCompatActivity.startActivityWithClass(
    vararg extras: Pair<String, Any?> = arrayOf(),
    flags: Int = 0,
    options: Bundle? = null
): AppCompatActivity {
    startActivity(Intent(this, T::class.java).apply {
        addFlags(flags)
        withExtras(*extras)
    }, options)
    return this
}

/**
 * Purpose: Add Pair extras to intent
 * Parameters:  data [Required] - variable amount of pairs to add to intent
 * Requires: -
 * Usage: Intent(this, MyClass::class.java).apply{ withExtras(TAG1 to data1, TAG2 to data2) }
 * Source: ?
 * Notes: Used by AppCompatActivity startActivityWithClass extension
 */
fun Intent.withExtras(vararg data: Pair<String, Any?>) {
    data.forEach {
        val key = it.first
        when (val value = it.second) {
            is Int -> putExtra(key, value)
            is Byte -> putExtra(key, value)
            is Char -> putExtra(key, value)
            is Long -> putExtra(key, value)
            is Float -> putExtra(key, value)
            is Short -> putExtra(key, value)
            is Double -> putExtra(key, value)
            is Boolean -> putExtra(key, value)
            is Bundle -> putExtra(key, value)
            is String -> putExtra(key, value)
            is IntArray -> putExtra(key, value)
            is ByteArray -> putExtra(key, value)
            is CharArray -> putExtra(key, value)
            is LongArray -> putExtra(key, value)
            is FloatArray -> putExtra(key, value)
            is Parcelable -> putExtra(key, value)
            is ShortArray -> putExtra(key, value)
            is DoubleArray -> putExtra(key, value)
            is BooleanArray -> putExtra(key, value)
            is CharSequence -> putExtra(key, value)
        }
    }
}

/**
 * Purpose: Begin fragment transaction with no animation
 * Parameters:  block [Required] - block to execute with fragment manager
 * Requires: -
 * Usage: supportFragmentManager.inTransaction {add(frameId, fragment)}
 * Source: ?
 * Notes: Used by AppCompatActivity extensions to control fragments
 */
inline fun FragmentManager.inTransaction(block: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().block().commit()
}

/**
 * Purpose: Add fragment with support fragment manager with no animation
 * Parameters:  fragment [Required] - fragment to create
 *              frameId [Required] - layout frame to put fragment in
 * Requires: FragmentManager extension inTransAction
 * Usage: addFragment(myFragment, R.id.frame)
 * Source: Brain
 * Notes: -
 */
fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

/**
 * Purpose: Replace fragment with support fragment manager with no animation
 * Parameters:  fragment [Required] - fragment to create
 *              frameId [Required] - layout frame to put fragment in
 * Requires: FragmentManager extension inTransAction
 * Usage: replaceFragment(myFragment, R.id.frame)
 * Source: Brain
 * Notes: -
 */
fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}





