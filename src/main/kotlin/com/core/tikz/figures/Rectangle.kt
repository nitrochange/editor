package com.core.tikz.figures

import com.core.tikz.util.Point

class Rectangle(startPoint: Point, var endPoint: Point, params:MutableList<String>):
    Figure(startPoint,"rectangle",params ) {

    fun paramsToTex() : String {
        return ""
    }

    override fun toTex() = "\\draw" + " " + "(${startPoint.x},${startPoint.y})" + " " +  type +
         " "+ "(${endPoint.x},${endPoint.y})" + paramsToTex() + ";"

}