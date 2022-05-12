package core.test.command

import com.core.tikz.commands.Line
import com.core.tikz.figures.Arrow
import com.core.tikz.node.LineWithText
import com.core.tikz.node.Node
import com.core.tikz.util.Point
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class LineTests {

    @Test
    fun simpleDrawCommandTest1() {
        val draw = Line(mutableListOf(), Point(0.0, 1.0), Point(1.0, 2.0))
        Assert.assertEquals("\\draw (0.0,1.0) -- (1.0,2.0);", draw.toTex())
    }

    @Test
    fun simpleDrawCommandTest2() {
        val draw = Line(mutableListOf(), Point(0.0, 1.0), Point(-1.3, -2.9), Point(2.4,-3.7))
        Assert.assertEquals("\\draw (0.0,1.0) -- (-1.3,-2.9) -- (2.4,-3.7);", draw.toTex())
    }

    @Test
    fun simpleDrawPolarTest1() {
        val polarDraw = Line(
            params = mutableListOf("red", "very thick"),
            points = mutableListOf(Line.PathPoint(0.0, -0.5, "+")),
            angle = 30,
            duration = "1cm"
        )
        Assert.assertEquals("\\draw[red,very thick] (30:1cm) -- +(0,-0.5);",polarDraw.toTex())
    }

    @Test
    fun simpleDrawPolarTest2() {
        val polarDraw = Line(
            params = mutableListOf("blue", "very thick"),
            points = mutableListOf(
                Line.PathPoint(0.0,-0.5, "++" ),
                Line.PathPoint(0.0, 0.0)),
            angle = 30,
            duration = "1cm"
        )
        Assert.assertEquals("\\draw[blue,very thick] (30:1cm) ++(0,-0.5) -- (0,0);", polarDraw.toTex())
    }

    @Test
    fun simpleArrowTest() {
        val arrow = Arrow("->", mutableListOf(Point(-1.5, 0.0), Point(1.5, 0.0)))
        Assert.assertEquals("\\draw[->] (-1.5,0.0) -- (1.5,0.0);", arrow.toTex())
    }

    @Test
    fun simpleLineWithNodesTest() {
        val map = mutableMapOf<Point, Node?>()
        map.put(Point(0.5,0.5), Node(mutableListOf("yellow","80","black"),"Text at \\verb!node 1!"))
        map.put(Point(1.5,1.5), Node(mutableListOf(),"Text at \\verb!node 2!"))

        val line = LineWithText(mutableListOf(), map)
        Assert.assertEquals("\\draw (0.5,0.5) node [fill=yellow!80!black]" +
                "{Text at \\verb!node 1!} " +
                "-- (1.5,1.5) node {Text at \\verb!node 2!};", line.toTex())
    }

}