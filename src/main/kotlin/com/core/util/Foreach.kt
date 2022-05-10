package com.core.util

import com.core.tikz.commands.Command

class Foreach(
    var variableName: String,
    var acceptableValues: MutableList<String>,
    var commands: MutableList<Command> ) :Command(name = "\\foreach", params = mutableListOf()) {

    fun acceptableValuestoTex() : String = acceptableValues.joinToString(",",prefix = "{", postfix = "}\n")


    override fun toTex(): String {
        return name + " \\${variableName}" + " in " + acceptableValuestoTex() +
                commands.map { it.toTex() }.joinToString(separator = "\n")
    }
}