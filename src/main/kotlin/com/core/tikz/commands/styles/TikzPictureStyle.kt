package com.core.tikz.commands.styles

class TikzPictureStyle(styleName:String, params: MutableList<String>, defaultParamValues: MutableList<String>): LocalStyle(styleName, params, defaultParamValues) {

    private var styles: MutableList<LocalStyle> = mutableListOf()
    private var innerSep = ""

    constructor(
        style1: LocalStyle,
        style2: LocalStyle,
        innerSep: String = ""
    ): this(style1.styleName, style1.params, style1.defaultParamValues) {
        styles.add(style1)
        styles.add(style2)
        this.innerSep = innerSep
    }

    private fun injectInnerSep(): String {
        if (innerSep != "") {
            return "inner sep=${innerSep},\n"
        }
        return ""
    }

    override fun toTex(): String {
        return "[${injectInnerSep()}${styles.get(0).styleName}/.style={${styles.get(0).params.joinToString(",")}},\n" +
                "${styles.get(1).styleName}/.style={${styles.get(1).params.joinToString(",")}}]"
    }
}