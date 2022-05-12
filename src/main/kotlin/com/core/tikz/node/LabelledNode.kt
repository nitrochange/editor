package com.core.tikz.node

class LabelledNode(params: MutableList<String>, text: String): Node(params, text){

    protected var label: String = ""
    protected override var innerName: String = ""

    constructor(
        label: String = "",
        params: MutableList<String> = mutableListOf(),
        innerName: String =""): this(params, "") {
        this.label = label
        this.innerName = innerName
    }

    override fun print(): String {
        return "\\node ${params.joinToString(",","[","]")} at (${innerName}) ${label};"
    }

}