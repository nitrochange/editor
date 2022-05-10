package core.test.command

import com.core.environments.Scope
import com.core.tikz.TikzPicture
import com.core.tikz.commands.Line
import com.core.tikz.util.Point
import org.junit.Assert
import org.junit.Test

class EnvironmentsTests {

    val expectedSimpleTikzPicture1 = """
        \begin{tikzpicture}
        
        \end{tikzpicture}
    """.trimIndent()

    val expectedSimpleTikzPicture2 = """
        \begin{tikzpicture}[scale=3]
        
        \end{tikzpicture}
    """.trimIndent()

    val expectedSimpleScope = """
        \begin{scope}[thin]
        \draw (1.0,0.0) -- (1.0,1.0);
        \draw (2.0,0.0) -- (2.0,1.0);
        \end{scope}
    """.trimIndent()


    @Test
    fun simpleEnvironmentTest() {
        val tikz = TikzPicture(mutableListOf())
        Assert.assertEquals(expectedSimpleTikzPicture1, tikz.toTex())
    }

    @Test
    fun simpleEnvironmentTestWithScale() {
        val tikz = TikzPicture(mutableListOf(),3)
        Assert.assertEquals(expectedSimpleTikzPicture2, tikz.toTex())
    }

    @Test
    fun simpleScopeWithCommandsTest() {
        val scope = Scope(mutableListOf(
            Line(mutableListOf(), Point(1.0,0.0), Point(1.0,1.0)),
            Line(mutableListOf(), Point(2.0, 0.0), Point(2.0, 1.0))
        ), mutableListOf("thin"))
        Assert.assertEquals(expectedSimpleScope,scope.getTexCode())
    }
}