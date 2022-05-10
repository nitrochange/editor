package core.test.command

import com.core.tikz.commands.Line
import com.core.tikz.util.Path
import com.core.tikz.util.Point
import com.core.util.Foreach
import org.junit.Assert
import org.junit.Test

class UtilTests {

    @Test
    fun simplePathTest1() {
        val path = Path(
            points = mutableListOf(Line.PathPoint(1.0, 0.0), Line.PathPoint(1.0,1.0)),
            params = mutableListOf("name path=upward line")
        )
        Assert.assertEquals("\\path [name path=upward line] (1,0) -- (1,1);", path.toTex());
    }

    @Test
    fun simplePathTest2() {
        val path = Path(
            points = mutableListOf(Line.PathPoint(0.0, 0.0)),
            params = mutableListOf("name path=sloped line"),
            endPoint = Line.PolarPoint(30, "1.5cm")
        )
        Assert.assertEquals("\\path [name path=sloped line] (0,0) -- (30:1.5cm);", path.toTex());
    }

    @Test
    fun simplePathTest3() {
        val simpleDrawCommand = Line(mutableListOf(), " [name intersections={of=upward line and sloped line, by=x}]" +
                "[very thick,orange] (1,0) -- (x);")
        Assert.assertEquals("\\draw [name intersections={of=upward line and sloped line, by=x}]" +
                "[very thick,orange] (1,0) -- (x);", simpleDrawCommand.toTex())
    }

    @Test
    fun simpleForeachTest() {
        val foreach = Foreach(
            variableName = "x",
            acceptableValues = mutableListOf("-1cm","-0.5cm","1cm"),
            commands = mutableListOf(Line(mutableListOf(), " (\\x,-1pt) -- (\\x,1pt);"))
        )
        Assert.assertEquals("\\foreach \\x in {-1cm,-0.5cm,1cm}\n" +
                "\\draw (\\x,-1pt) -- (\\x,1pt);", foreach.toTex())
    }



}