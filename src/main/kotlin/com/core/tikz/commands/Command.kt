package com.core.tikz.commands

abstract class Command(var name: String = "\\draw", var params: MutableList<String>) {
    abstract fun toTex() : String
}