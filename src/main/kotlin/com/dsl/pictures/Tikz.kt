package com.dsl.pictures

import com.core.tikz.TikzPicture
import com.core.util.Colorlet

class Tikz {
}
fun params(init: () -> Unit): MutableList<String> {
    val params = mutableListOf("scale=3", "line cap=round", "axes/.style=", "important line/.style={very thick}")
    return  params
}

fun colorlet(init: Colorlet.() -> Unit): Colorlet {
    val colorlet = Colorlet("name", mutableListOf())
    colorlet.init()
    return colorlet
}

fun tikz(init: TikzPicture.() -> Unit): TikzPicture {
    val tikz = TikzPicture(mutableListOf())
    tikz.init()
    return tikz
}