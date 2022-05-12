package com.core.tikz.node

import com.core.tikz.util.Edge
import java.lang.StringBuilder

class EdgedNode(styleName: String = "",
                innerName: String = "",
                params: MutableList<String> = mutableListOf()):Node(styleName, innerName, params) {

    var edges: MutableList<Edge> = mutableListOf()

    constructor(
        styleName: String = "",
        innerName: String = "",
        params: MutableList<String> = mutableListOf(),
        edges: MutableList<Edge>):this(styleName, innerName,params) {
        this.edges = edges
    }


    override fun print(): String {
        val str = StringBuilder()
        str.append("\\node[${styleName}] (${innerName}) ${params.joinToString(",","[","]")} {}\n")
        edges.forEach {
            str.append(it.toTex() + "\n")
        }

        return "${str.dropLast(1)};"
    }

}