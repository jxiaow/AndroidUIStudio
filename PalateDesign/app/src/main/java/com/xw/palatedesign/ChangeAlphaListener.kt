package com.xw.palatedesign

interface ChangeAlphaListener<out T> : Function<T> {
    fun changeAlpha(alpha: Float)
}