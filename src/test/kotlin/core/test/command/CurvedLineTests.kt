package core.test.command

import com.core.tikz.commands.CurvedLine
import com.core.tikz.util.Point
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class CurvedLineTests {

    @Test
    fun simpleCurvedLineTest1() {
        val curvedLine = CurvedLine(mutableListOf(),
        Point(0.0, 0.0), Point(2.0,2.0),
        Point(4.0, 2.0), Point(6.0, 0.0)
        )

        Assert.assertEquals("\\draw (0.0,0.0) .. controls (2.0,2.0) and (4.0,2.0) .. (6.0,0.0);", curvedLine.toTex())
    }

    @Ignore
    @Test
    fun simpleCurvedLineTest2() {

    }

    @Ignore
    @Test
    fun simpleCurvedLineTestNegative() {

    }
}