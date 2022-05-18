package com.core.util

import com.core.tikz.commands.Command

public class Colorlet(val colorname: String, params: MutableList<String>): Command(name = "\\colorlet", params = params) {

    override fun toTex(): String = name + "{${colorname}}" + params.joinToString("!", "{", "}") + ";"

}