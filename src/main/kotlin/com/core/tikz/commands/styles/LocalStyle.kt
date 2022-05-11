package com.core.tikz.commands.styles

open class LocalStyle(styleName:String, params: MutableList<String>, var defaultParamValues: MutableList<String>): Style(commandName ="", styleName, params) {

    override fun toTex(): String {
        return "[${styleName}/.style ={${params.joinToString(separator = ",")}}," + "\n" +
                "${styleName}/.default=${defaultParamValues.joinToString(separator = ",")}]."
    }
}