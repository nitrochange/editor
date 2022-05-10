package com.core.tikz.node

import com.core.tikz.commands.Line
import com.core.tikz.util.Point

class LineWithText(params: MutableList<String>, var pointsWithNodes: MutableMap<Point, Node?>): Line(params) {

    override fun toTex(): String {
        return name + " " + pointsWithNodes.map {
            if (it.value != null) {
                "(${it.key.x},${it.key.y})" + it.value!!.print()
            } else {
                "(${it.key.x},${it.key.y})"
            }
        }.joinToString(" -- ") + ";"
    }
}