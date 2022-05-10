package core.test.command

import com.core.tikz.commands.FillDraw
import com.core.tikz.commands.FilledArc
import com.core.tikz.util.Point
import org.junit.Assert
import org.junit.Test

class FillingTests {

    @Test
    fun simpleFillTest() {
        val fill = FilledArc(
            colors = mutableListOf("green", "20", "white"),
            points = mutableListOf(Point(0.0,0.0), Point(3.0,0.0)),
            params = mutableListOf("start angle=0", "end angle=30","radius=3mm"))
        Assert.assertEquals("\\fill[green!20!white] (0,0) -- (3mm,0mm) " +
                "arc [start angle=0, end angle=30, radius=3mm] -- cycle;", fill.toTex())
    }

    @Test
    fun simpleFillDrawTest() {
        val filldraw = FillDraw(
            fill = mutableListOf("green", "20", "white"),
            draw = mutableListOf("green", "50", "black"),
            points = mutableListOf(Point(0.0,0.0), Point(3.0,0.0)),
            params = mutableListOf("start angle=0","end angle=30", "radius=3mm"))
        Assert.assertEquals("\\filldraw[fill=green!20!white, draw=green!50!black] (0,0) -- (3mm,0mm) " +
                "arc [start angle=0, end angle=30, radius=3mm] -- cycle;",filldraw.toTex())
    }
}