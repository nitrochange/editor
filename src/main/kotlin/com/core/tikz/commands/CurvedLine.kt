package com.core.tikz.commands

import com.core.tikz.util.Point

class CurvedLine(params: MutableList<String>, vararg points: Point): Line(params, *points) {

    val twoDots = " .. "

    init {
     if (points.size <= 2) throw IllegalArgumentException("Curved Line must have more than 2 points")
    }



    override fun toTex(): String {
        if (points.size != 4) throw RuntimeException()
        return name + " " +"(${points[0].x},${points[0].y})" + twoDots +
                "controls" + " " + "(${points[1].x},${points[1].y})" + " " +
                "and" + " " + "(${points[2].x},${points[2].y})" + twoDots +
                "(${points[3].x},${points[3].y})" + ";";
    }
}