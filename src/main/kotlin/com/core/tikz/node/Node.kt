package com.core.tikz.node

import com.core.tikz.util.Point


class Node(var params: MutableList<String>, var text: String) {

    private var nodeInPath = false
    private var shift = 0
    private val node = " node "
    private var isNodeAt = false
    private var startPoint: Point = Point(0,0)

    constructor(
        nodeInPath: Boolean = false,
        shift: Int = 0,
        params: MutableList<String>,
        text: String):this(params, text) {
        this.nodeInPath = nodeInPath
        this.shift = shift
    }

    constructor(
        isNodeAt: Boolean,
        params: MutableList<String>,
        startPoint: Point
    ): this(params, "") {
        this.isNodeAt = isNodeAt
        this.startPoint = startPoint
    }

    fun print(): String {
        if (nodeInPath) {
            return " ".repeat(shift) + node + params.joinToString("," , prefix = "[", postfix = "]") + " {}"
        }
        if (isNodeAt) {
            return "\\node at ( ${startPoint.x.toInt()},${startPoint.y.toInt()}) ${params.joinToString(",", "[", "]")} {};"
        }
        if (params.isEmpty()) {
            return node + params.joinToString("!") + "{${text}}"
        } else {
            return node + params.joinToString("!", "[fill=", "]") + "{${text}}"
        }
    }
}