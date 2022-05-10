package com.core.tikz.figures

import com.core.tikz.commands.Command
import com.core.tikz.util.Point

class Arrow(direction: String, var points: MutableList<Point>): Command(params = mutableListOf(direction)) {

    fun pointsToTex() : String = points.map { "(${it.x},${it.y})" }.joinToString(
        separator = " -- "
    )

    override fun toTex(): String {
        return name + "[${params[0]}]" + " " + pointsToTex() + ";"
    }

}