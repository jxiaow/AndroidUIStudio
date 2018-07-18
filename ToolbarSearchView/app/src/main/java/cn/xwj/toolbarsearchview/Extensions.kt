package cn.xwj.toolbarsearchview

import android.content.Context
import android.support.v7.widget.SearchView
import android.view.Menu
import android.widget.Toast

/**
 * Author: xw
 * Date: 2018-07-18 10:13:57
 * Description: Extensions: .
 */
fun Context.toastLong(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Menu.setOptionalIconsVisible() {
    try {
        if (this::class.java.simpleName.equals("MenuBuilder", true)) {
            val method = this::class.java.getDeclaredMethod("setOptionalIconsVisible",
                    Boolean::class.java)
            method.isAccessible = true
            method.invoke(this, true)
        }

    } catch (e: Exception) {
    }
}

fun SearchView.close() {
    try {
        val method = SearchView::class.java.getDeclaredMethod("onCloseClicked")
        method.isAccessible = true
        method.invoke(this)
    } catch (e: Exception) {
    }
}