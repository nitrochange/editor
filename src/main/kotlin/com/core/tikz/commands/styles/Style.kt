package com.core.tikz.commands.styles

import com.core.tikz.commands.Command

abstract class Style(commandName: String, var styleName: String, params: MutableList<String>): Command(commandName, params) {

}