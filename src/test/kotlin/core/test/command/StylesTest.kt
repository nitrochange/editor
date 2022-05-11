package core.test.command

import com.core.tikz.commands.styles.GlobalStyle
import com.core.tikz.commands.styles.LocalStyle
import com.core.tikz.commands.styles.TikzPictureStyle
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

    @Test
    fun simpleTestStyleForPetriNetWithOutInnerSep() {
        val style = TikzPictureStyle(
            style1 = LocalStyle("place", mutableListOf("circle","draw=blue!50","fill=blue!20","thick"), mutableListOf()),
            style2 = LocalStyle("transition", mutableListOf("rectangle","draw=black!50","fill=black!20","thick"), mutableListOf())
        )
        Assert.assertEquals("[place/.style={circle,draw=blue!50,fill=blue!20,thick},\ntransition/.style={rectangle,draw=black!50,fill=black!20,thick}]", style.toTex())
    }

    @Test
    fun simpleTestStyleForPetriNetWithInnerSep() {
        val style = TikzPictureStyle(
            style1 = LocalStyle("place", mutableListOf("circle","draw=blue!50","fill=blue!20","thick"), mutableListOf()),
            style2 = LocalStyle("transition", mutableListOf("rectangle","draw=black!50","fill=black!20","thick"), mutableListOf()),
            innerSep = "2mm"
        )

        Assert.assertEquals("[inner sep=2mm,\n" +
                "place/.style={circle,draw=blue!50,fill=blue!20,thick},\n" +
                "transition/.style={rectangle,draw=black!50,fill=black!20,thick}]",style.toTex())
    }

    @Test
    fun complexTestStyleForPetriNet() {
        val style = TikzPictureStyle(
            style1 = LocalStyle("place", mutableListOf("circle", "draw=blue!50","fill=blue!20","thick","inner sep=0pt", "minimum size=6mm"), mutableListOf()),
            style2 = LocalStyle("transition", mutableListOf("rectangle","draw=black!50","fill=black!20","thick","inner sep=0pt,minimum size=4mm"), mutableListOf())
        )

        Assert.assertEquals("[place/.style={circle,draw=blue!50,fill=blue!20,thick,inner sep=0pt,minimum size=6mm},\n" +
                "transition/.style={rectangle,draw=black!50,fill=black!20,thick,inner sep=0pt,minimum size=4mm}]", style.toTex())
    }
}