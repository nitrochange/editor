package com.core.tikz.commands.styles

class GlobalStyle(styleName: String, params: MutableList<String>): Style(commandName = "\\tikzset", styleName, params) {

    override fun toTex(): String {
        return name + "{${styleName}/.style=${params.joinToString()}}"
    }
}