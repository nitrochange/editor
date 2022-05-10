package core.test.command

import com.core.tikz.commands.styles.GlobalStyle
import com.core.tikz.commands.styles.LocalStyle
import org.junit.Assert
import org.junit.Test

class StylesTest {

    @Test
    fun simpleTestGlobalStyle1() {
        val style: GlobalStyle = GlobalStyle("test style", mutableListOf("very thin"))
        Assert.assertEquals("\\tikzset{test style/.style=very thin}", style.toTex())
    }

    @Test
    fun simpleTestLocalStyle1() {
        val style = LocalStyle("Karl's grid", mutableListOf("help lines","color=#1!50"), mutableListOf("blue"))
        Assert.assertEquals("[Karl's grid/.style ={help lines,color=#1!50},\nKarl's grid/.default=blue].", style.toTex())
    }
}