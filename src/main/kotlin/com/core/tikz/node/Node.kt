package com.core.tikz.node

import com.core.tikz.util.Point


class Node(var params: MutableList<String>, var text: String) {

    private var nodeInPath = false
    private var shift = 0
    private val node = " node "
    private var isNodeAt = false
    private var startPoint: Point = Point(0,0)
    private var innerName: String = ""
    private var liberalSyntax = false

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

    constructor(
        isNodeAt: Boolean,
        params: MutableList<String>,
        startPoint: Point,
        name: String = "",
        liberalSyntax: Boolean = false
    ): this(params, "") {
        this.isNodeAt = isNodeAt
        this.startPoint = startPoint
        this.innerName = name
        this.liberalSyntax = liberalSyntax
    }

    fun print(): String {
        if (innerName != "" && isNodeAt) {
            if (liberalSyntax) {
                return "\\node${params.joinToString(",","[","]")} (${innerName}) at ( ${startPoint.x.toInt()},${startPoint.y.toInt()}) {};"
            } else {
                return "\\node (${innerName}) at ( ${startPoint.x.toInt()},${startPoint.y.toInt()}) ${params.joinToString(",","[","]")} {};"
            }
        }
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