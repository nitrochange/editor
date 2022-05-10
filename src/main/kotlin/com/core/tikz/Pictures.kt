package com.core.tikz

import com.core.tikz.commands.Line
import com.core.tikz.util.Point

class TikZ {}


fun tikz(init: TikZ.() -> Unit): TikZ {
    val picture = TikZ()
    picture.init()
    return picture
}


fun main() {
//    val picture = tikz {
//
//    }
    val draw = Line(mutableListOf(), Point(1.0, 1.0), Point(1.0, 1.0))
    println(draw.toTex())
}