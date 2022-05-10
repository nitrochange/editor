package com.core.latex

interface Element {
    fun print()
}
abstract class abstractElement(val text:String, var args: MutableList<String>): Element {

}
