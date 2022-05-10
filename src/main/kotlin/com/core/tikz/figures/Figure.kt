package com.core.tikz.figures

import com.core.tikz.commands.Command
import com.core.tikz.util.Point

abstract class Figure(val startPoint: Point = Point(0.0, 0.0),
                      val type: String = "circle",
                      params: MutableList<String>,
                      command: String  = "\\draw"): Command(name=command,params) {
}