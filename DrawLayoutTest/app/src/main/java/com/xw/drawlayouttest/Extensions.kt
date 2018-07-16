package com.xw.drawlayouttest

inline fun <T, R> T?.with(block: T.() -> R): R? {
    return this?.block()
}