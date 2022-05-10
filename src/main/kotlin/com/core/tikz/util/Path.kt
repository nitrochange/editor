package com.core.tikz.util

import com.core.tikz.commands.Command
import com.core.tikz.commands.Line

class Path(
    val points: MutableList<Line.PathPoint>,
    val endPoint: Line.PolarPoint? = null,
    params: MutableList<String>): Command(name = "\\path", params) {

    private fun paramsToTex() = params.joinToString(separator =",",prefix = "[", postfix = "]")

    private fun pointsToTex() : String {
        val texedPoints = StringBuilder()
        texedPoints.append(points.map { "(${it.x.toInt()},${it.y.toInt()})" }
            .joinToString(" -- "))
        if (endPoint != null) {
            texedPoints.append(" -- (${endPoint.angle}:${endPoint.duration})")
        }
        return texedPoints.toString()
    }

    override fun toTex(): String {
        return name + " " + paramsToTex() + " " + pointsToTex() + ";"
    }

}