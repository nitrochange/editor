package com.core.tikz.figures

import com.core.tikz.util.Point

class Grid(startPoint: Point, var endPoint: Point, params:MutableList<String>): Figure(startPoint,"grid",params ) {

    fun paramsToTex() : String {

        return params.joinToString(separator = ",",prefix = "[", postfix = "]")
    }

    override fun toTex() = "\\draw" + paramsToTex() + " " + "(${startPoint.x},${startPoint.y})" + " " +  type +
            " "+ "(${endPoint.x},${endPoint.y})" + ";"

}