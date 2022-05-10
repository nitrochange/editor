package com.core.environments

import com.core.tikz.commands.Command

class Scope(var commands: MutableList<Command>, var scopeParams: MutableList<String>? = null) : Environment, Command(params = mutableListOf()) {

    override fun getTexCode(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("\\begin{scope}")
        if (scopeParams != null) {
            stringBuilder.append("[${scopeParams!!.joinToString(",")}]")
        }
        stringBuilder.append("\n")

        for (command in commands) {
            stringBuilder.append(command.toTex())
            stringBuilder.append("\n")
        }

        stringBuilder.append("\\end{scope}")
        return stringBuilder.toString()
    }

    override fun toTex(): String {
        return getTexCode()
    }
}