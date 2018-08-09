package cn.xwj.discrollview.view

/**
 * Author: xw
 * Date: 2018-08-09 14:29:16
 * Description: DiScrollableInterface: .
 */
interface DiScrollableInterface {
    /**
     * 当滑动的时候调用该方法，用来控制里面的控件执行相应的动画
     * @param ratio
     */
    fun onDiScroll(ratio: Float)

    /**
     * 重置view的属性----恢复view的原来属性
     */
    fun onResetDiScroll()
}