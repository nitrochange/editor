package com.core.tikz.commands

class LineConnectingNodes(): Line(mutableListOf(),"\\draw") {

    private var begin: String = ""
    private var end: String = ""
    private var direction: String = ""


    constructor(
        begin: String = "",
        end: String = "",
        direction:String = "",
        params: MutableList<String> = mutableListOf()):this() {
        this.begin = begin
        this.end = end
        this.direction = direction
        this.params = params
    }

    private fun fillParams(): String {
        if (params.isEmpty()) {
            return " -- "
        } else {
            return "to ${params.joinToString(",","[","]")}"
        }
    }


    override fun toTex(): String {
        return "\\draw [${direction}] (${begin}) ${fillParams()} (${end});"
    }

}