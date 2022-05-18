package com.core.tikz

import com.core.tikz.commands.Command

/**
 * @param commands - inner commands
 * @param scale - this param can reduce or increase picture size in general
 * @param params - params for configuring picture in a while
 */
class TikzPicture(
    var commands: MutableList<Command>,
    var scale: Int? = null,
    var params: MutableList<String> = mutableListOf()) {


    fun toTex(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("\\begin{tikzpicture}")
        if (scale != null) {
            stringBuilder.append("[scale=${scale}]")
        }
        if (!params.isEmpty()) {
            stringBuilder.append(params.joinToString(
                separator = ",",
                prefix = "[",
                postfix = "]"
            ))
        }
        stringBuilder.append("\n")

        for (command in commands) {
            stringBuilder.append(command.toTex())
            stringBuilder.append("\n")
        }

        stringBuilder.append("\n")
        stringBuilder.append("\\end{tikzpicture}")

        return stringBuilder.toString()

    }
}