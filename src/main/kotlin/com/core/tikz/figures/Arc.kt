package com.core.tikz.figures

import com.core.tikz.util.Point

class Arc(startPoint: Point, params:MutableList<String>, var command: String ="\\draw"):
    Figure(startPoint,"arc",params,command ) {

    fun paramsToTex() : String = "[" + params.joinToString(separator = ",") + "]"

    override fun toTex(): String {
        if (command == "\\draw") {
            return "\\draw" + " " + "(${startPoint.x.toInt()}mm,${startPoint.y.toInt()}mm)" + " " + type + " " + paramsToTex() + ";"
        } else {
            return ""
        }
    }

}