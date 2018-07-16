package cn.xwj.recyclerviewtest.util

/**
 * Author: xw
 * Date: 2018-07-16 09:49:34
 * Description: DataUtil: .
 */
object DataUtil {


    fun init(): MutableList<String> {
        val list: MutableList<String> = mutableListOf()

        for (i in 0..20) {
            list.add("$i 条目")
        }
        return list
    }
}