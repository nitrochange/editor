package com.core.tikz.commands

import com.core.tikz.util.Point


class FillDraw(var fill: MutableList<String>,
               var draw: MutableList<String>,
               var points: MutableList<Point>,
               params: MutableList<String>): Command(name ="\\filldraw", params = params) {

    private fun printPointsToTex(): String {
        return " (${points[0].x.toInt()},${points[0].y.toInt()})" + " -- " +
                "(${points[1].x.toInt()}mm,${points[1].y.toInt()}mm)"
    }

    override fun toTex(): String {
        return name + "[fill=${fill.joinToString(separator = "!")}, draw=${draw.joinToString(separator = "!")}]" +
                printPointsToTex() + " arc " +
                params.joinToString(separator = ", ", prefix = "[", postfix = "] ")+ "-- cycle;"
    }

}