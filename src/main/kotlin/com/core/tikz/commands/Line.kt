package com.core.tikz.commands

import com.core.tikz.util.Point

open class Line(params: MutableList<String>, vararg points: Point) : Command(name = "\\draw", params) {
    var points: MutableList<Point> = mutableListOf()
    var isPolar = false
    var startPolarPoint = PolarPoint()
    var polarPoints: MutableList<PathPoint> = mutableListOf()
    var command: String = ""
    var isSimpleCommand = false

    data class PolarPoint(val angle: Int = 0, val duration: String = "1cm")
    class PathPoint(x_offset: Double, y_offset: Double, val prefix: String = "") : Point(x_offset, y_offset)

    constructor(
        params: MutableList<String>,
        angle: Int = 0,
        duration: String = "1cm",
        points: MutableList<PathPoint>
    ) : this(params) {
        isPolar = true

        startPolarPoint = PolarPoint(angle = angle, duration = duration)

        for (point in points) {
            this.polarPoints.add(point)
        }
    }

    constructor(
        params: MutableList<String>,
        command: String
        ):this(params) {
        isSimpleCommand = true
        this.command = command
    }

    init {
        for (point in points) {
            this.points.add(point)
        }
    }

    private fun paramsToTex(): String {
        if (params.isEmpty()) return ""
        return params.joinToString(separator = ",", prefix = "[", postfix = "]")
    }

    protected fun pointsToTex(): String {
        val texedPoints = StringBuilder()
        if (!isPolar) {
            for (i in 0 until points.size) {
                texedPoints.append("(${points[i].x},${points[i].y})")
                if (i < points.size - 1) {
                    texedPoints.append(" -- ")
                }
            }
        } else {
            texedPoints.append("(${startPolarPoint.angle}:${startPolarPoint.duration}) ")
            if (polarPoints.size == 1) {
                texedPoints.append("-- ${polarPoints[0].prefix}(${polarPoints[0].x.toInt()},${polarPoints[0].y})")
            } else {

                for (polarPoint in polarPoints) {
                    if (polarPoint.prefix.isNotEmpty()) {
                        texedPoints.append("${polarPoint.prefix}(${polarPoint.x.toInt()},${polarPoint.y})")
                    } else {
                        texedPoints.append(" -- (${polarPoint.x.toInt()},${polarPoint.y.toInt()})")
                    }
                }
            }
        }
        return texedPoints.toString()
    }

    override fun toTex(): String {
        if (isSimpleCommand) {
            return name + paramsToTex() +command;
        } else {
            return name + paramsToTex() + " " + pointsToTex() + ";"
        }
    }


}