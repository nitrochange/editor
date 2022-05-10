package com.core.tikz.figures

import com.core.tikz.util.Point

class Circle(startPoint: Point, params:MutableList<String>): Figure(startPoint,"circle",params ) {

    fun paramsToTex() : String = "[" + params[0] + "]"

    override fun toTex() = "\\draw" + " " + "(${startPoint.x},${startPoint.y})" + " " + type + " " + paramsToTex() + ";"

}