package core.test.command

import com.core.tikz.figures.Arc
import com.core.tikz.figures.Circle
import com.core.tikz.figures.Grid
import com.core.tikz.figures.Rectangle
import com.core.tikz.util.Point
import org.junit.Assert
import org.junit.Test

class FiguresTests {

    @Test
    fun simpleRectangleTest1() {
        val rectange = Rectangle(Point(0.0,0.0), Point(3.0,3.0), mutableListOf())
        Assert.assertEquals("\\draw (0.0,0.0) rectangle (3.0,3.0);",rectange.toTex())
    }
    @Test
    fun simpleRectangeTest2() {
        val rectange = Rectangle(Point(-1.1,-2.2), Point(4.7, 2.5), mutableListOf())
        Assert.assertEquals("\\draw (-1.1,-2.2) rectangle (4.7,2.5);", rectange.toTex())
    }


    @Test
    fun simpleCircleTest1() {
        val circle = Circle(Point(0.0,0.0), mutableListOf("radius=1cm"))
        Assert.assertEquals("\\draw (0.0,0.0) circle [radius=1cm];",circle.toTex());
    }

    @Test
    fun simpleCircleTest2() {
        val circle = Circle(Point(1.2, 3.4), mutableListOf("radius=2cm"))
        Assert.assertEquals("\\draw (1.2,3.4) circle [radius=2cm];",circle.toTex())
    }

    @Test
    fun simpleGridTest1() {
        val grid = Grid(Point(1.2,3.4), Point(-1.4,-1.3), mutableListOf("step=.5cm"))
        Assert.assertEquals("\\draw[step=.5cm] (1.2,3.4) grid (-1.4,-1.3);", grid.toTex())
    }

    @Test
    fun simpleGridTest2() {
        val grid = Grid(Point(1.2,3.4), Point(-1.4,-1.3), mutableListOf("step=.5cm","gray","very thin"))
        Assert.assertEquals("\\draw[step=.5cm,gray,very thin] (1.2,3.4) grid (-1.4,-1.3);", grid.toTex())
    }

    @Test
    fun simpleArcTest1() {
        val arc = Arc(Point(3.0,0.0), mutableListOf("start angle=0","end angle=30","radius=3mm"))
        Assert.assertEquals("\\draw (3mm,0mm) arc [start angle=0,end angle=30,radius=3mm];",arc.toTex())
    }
}