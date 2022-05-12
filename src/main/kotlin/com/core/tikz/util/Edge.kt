package com.core.tikz.util

import com.core.tikz.commands.Command

class Edge(params: MutableList<String>, var endPoint: String = ""): Command("edge", params) {

    private var extraParams: String = ""

    constructor(
        params: MutableList<String>,
        endPoint: String,
        extraParams: String): this(params, endPoint) {
            this.extraParams = extraParams
        }

    private fun insertExtraParams() = extraParams.ifEmpty { "" }


    override fun toTex(): String {
        return "edge ${params.joinToString(",","[","]")} ${insertExtraParams()}(${endPoint})"
    }

}