package cn.xwj.recyclerviewtest

/**
 * Author: xw
 * Date: 2018-07-16 17:38:26
 * Description: Extensions: .
 */
inline fun <T, R> T?.safeCall(block: T.() -> R): R? {
    return this?.block()
}