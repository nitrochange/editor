package core.test.command.`petri-net`

import com.core.tikz.node.Node
import com.core.tikz.util.Path
import com.core.tikz.util.Point
import org.junit.Assert
import org.junit.Test

class PathTests {
    val expectedSimpleResult = """
\path ( 0,2) node [shape=circle,draw] {}
      ( 0,1) node [shape=circle,draw] {}
      ( 0,0) node [shape=circle,draw] {}
      ( 1,1) node [shape=rectangle,draw] {}
      ( -1,1) node [shape=rectangle,draw] {};
    """.trimIndent()

    val expectedSimpleResult2 = """
\node at ( 0,2) [circle,draw] {};
    """.trimIndent()

    fun createAndFillNodesExample(): MutableMap<Point, Node> {
        val nodes = mutableMapOf<Point, Node>()
        nodes.put(Point(0, 2), Node(true, 0, mutableListOf("shape=circle,draw"), ""))
        nodes.put(Point(0, 1), Node(true, 0, mutableListOf("shape=circle,draw"), ""))
        nodes.put(Point(0, 0), Node(true, 0, mutableListOf("shape=circle,draw"), ""))
        nodes.put(Point(1, 1), Node(true, 0, mutableListOf("shape=rectangle,draw"), ""))
        nodes.put(Point(-1, 1), Node(true, 0, mutableListOf("shape=rectangle,draw"), ""))
        return nodes
    }

    @Test
    fun pathForPetriNetsSimpleTest1() {
        val path = Path(
            isNodeSequence = true,
            nodes = createAndFillNodesExample(),
            params = mutableListOf(),
            shifts = mutableListOf(1,6,6,6,6)
        )
        Assert.assertEquals(expectedSimpleResult, path.toTex())
    }

    @Test
    fun nodeForPetriNetsSimpleTest2() {
        val node = Node(isNodeAt = true, mutableListOf("circle", "draw"), Point(0,2))
        Assert.assertEquals(expectedSimpleResult2, node.print())
    }
}