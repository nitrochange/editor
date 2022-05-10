package com.core.tikz.node

class Node(var params: MutableList<String>, var text: String) {

    fun print(): String {
        if (params.isEmpty()) {
            return " node " + params.joinToString("!") + "{${text}}"
        } else {
            return " node " + params.joinToString("!", "[fill=", "]") + "{${text}}"
        }
    }
}