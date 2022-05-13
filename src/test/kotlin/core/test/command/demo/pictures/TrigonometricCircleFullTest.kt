package core.test.command.demo.pictures

import com.core.environments.Scope
import com.core.tikz.TikzPicture
import com.core.tikz.commands.Command
import com.core.tikz.commands.FilledArc
import com.core.tikz.commands.Line
import com.core.tikz.figures.Circle
import com.core.tikz.figures.Grid
import com.core.tikz.util.Path
import com.core.tikz.util.Point
import com.core.util.Colorlet
import com.core.util.Foreach
import org.junit.Test

class TrigonometricCircleFullTest {

    val fullText = """
        
    """.trimIndent()

    fun prepareAxes(): Scope {
        val scope = Scope(
            mutableListOf(
                Line(mutableListOf("->")," (-1.5,0) -- (1.5,0) node[right] {\$x\$} coordinate(x axis);"),
                Line(mutableListOf("->"), " (0,-1.5) -- (0,1.5) node[above] {\$y\$} coordinate(y axis);"),
                Foreach("\\x/\\xtext", mutableListOf("-1", "-.5/-\\frac{1}{2}", "1"),
                    mutableListOf(
                        Line(mutableListOf("xshift=\\x cm"), "(0pt,1pt) -- (0pt,-1pt) node[below,fill=white] {\$\\xtext\$};")
                    )),
                Foreach("\\y/\\ytext", mutableListOf("-1", "-.5/-\\frac{1}{2}", ".5/\\frac{1}{2}", "1"),
                    mutableListOf(
                        Line(mutableListOf("yshift=\\y cm"), "(1pt,0pt) -- (-1pt,0pt) node[left,fill=white] {\$\\ytext\$};")
                    )),

            ),
            mutableListOf("axes")
        )
        return scope
    }

    fun intersect() = "[very thick,orange] (1,0) -- node [right=1pt,fill=white]\n" +
            "{\$\\displaystyle \\tan \\alpha \\color{black}=\n" +
            "\\frac{{\\color{red}\\sin \\alpha}}{\\color{blue}\\cos \\alpha}\$} (t);"


    @Test
    fun fullPictureTest1() {
        val tikzParams = mutableListOf(
            "scale=3",
            "line cap=round",
            "axes/.style=",
            "important line/.style={very thick}",
            "information text/.style={rounded corners,fill=red!10,inner sep=1ex}")

        val commands = mutableListOf<Command>(
            //colors
            Colorlet("anglecolor", mutableListOf("green", "50", "black")),
            Colorlet("sincolor", mutableListOf("red")),
            Colorlet("tancolor", mutableListOf("orange", "80", "black")),
            Colorlet("coscolor", mutableListOf("blue")),

            //graphic environment
            Grid(Point(-1.4,-1.4), Point(1.4,1.4), mutableListOf("help lines", "step=0.5cm")),
            Circle(Point(0,0),mutableListOf("radius=1cm")),
            prepareAxes(),
            //drawing

            FilledArc(
                colors = mutableListOf("green", "20", "white"),
                points = mutableListOf(Point(0.0,0.0), Point(3.0,0.0)),
                params = mutableListOf("start angle=0", "end angle=30","radius=3mm")),
            Line(mutableListOf("important line","coscolor"), "(30:1cm) -- node[left=1pt,fill=white] {\$\\sin \\alpha\$} (30:1cm |- x axis);"),
            Line(mutableListOf("important line","sincolor"), "(30:1cm |- x axis) -- node[below=2pt,fill=white] {\$\\cos \\alpha\$} (0,0);"),
            Path( points = mutableListOf(Line.PathPoint(1.0, 0.0), Line.PathPoint(1.0,1.0)),params = mutableListOf("name path=upward line")),
            Path(mutableListOf(Line.PathPoint(0.0, 0.0)), Line.PolarPoint(30, "1.5cm"), mutableListOf("name path=sloped line")),

            Line(mutableListOf("name intersections={of=upward line and sloped line, by=t}"), intersect()),

            Line(mutableListOf(), "(0,0) -- (t);"),
            Line(mutableListOf("xshift=1.85cm"), "node[right,text width=6cm,information text]\n" +
                    "{\n" +
                    "The {\\color{anglecolor} angle \$\\alpha\$} is \$30^\\circ\$ in the\n" +
                    "example (\$\\pi/6\$ in radians). The {\\color{sincolor}sine of\n" +
                    "\$\\alpha\$}, which is the height of the red line, is\n" +
                    "\\[\n" +
                    "{\\color{sincolor} \\sin \\alpha} = 1/2.\n" +
                    "\\]\n" +
                    "By the Theorem of Pythagoras ...\n" +
                    "}")
        )
        val tikz = TikzPicture(commands, params = tikzParams)

        println(tikz.toTex())

    }
}