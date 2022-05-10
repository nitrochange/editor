package com.core.tikz.util

open class Point(val x: Double, val y:Double) {
    constructor(x: Int, y: Int) : this(x.toDouble(),y.toDouble())
}