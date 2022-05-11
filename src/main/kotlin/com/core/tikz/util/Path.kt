package com.core.tikz.util

import com.core.tikz.commands.Command
import com.core.tikz.commands.Line
import com.core.tikz.node.Node

class Path(
    val points: MutableList<Line.PathPoint>,
    val endPoint: Line.PolarPoint? = null,
    params: MutableList<String>): Command(name = "\\path", params) {

    private var isNodeSequence = false;
    private var nodes: MutableMap<Point, Node> = mutableMapOf()
    private var shifts: MutableList<Int> = mutableListOf()

    constructor(
        isNodeSequence: Boolean,
        nodes: MutableMap<Point, Node>,
        shifts: MutableList<Int>,
        params: MutableList<String>
        ): this(mutableListOf(), null,params){
        this.isNodeSequence = isNodeSequence
        this.nodes = nodes
        this.shifts = shifts
    }

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
        if (isNodeSequence) {
            val stringBuilder = StringBuilder()
            stringBuilder.append(name)
            var i = 0
            for (node in this.nodes) {
                stringBuilder.append("${" ".repeat(shifts[i])}( ${node.key.x.toInt()},${node.key.y.toInt()})${node.value.print()}\n")
                i++
            }
            return stringBuilder.dropLast(1).toString() + ";"
        } else {
            return name + " " + paramsToTex() + " " + pointsToTex() + ";"
        }
    }

}