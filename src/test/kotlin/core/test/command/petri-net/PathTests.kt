package core.test.command.`petri-net`

import com.core.tikz.node.LabelledNode
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

    @Test
    fun namingNodeForPetriNetsSimpleTest() {
        val node = Node(
            isNodeAt = true,
            params = mutableListOf("place"),
            startPoint = Point(0, 2),
            name = "waiting 1"
        )
        Assert.assertEquals("\\node (waiting 1) at ( 0,2) [place] {};", node.print())
    }

    @Test
    fun liberalSyntaxWithNamingNodeForPetriNetsSimpleTest() {
        val node = Node(
            isNodeAt = true,
            params = mutableListOf("place"),
            startPoint = Point(0,2),
            name = "waiting 1",
            liberalSyntax = true
        )
        Assert.assertEquals("\\node[place] (waiting 1) at ( 0,2) {};", node.print())
    }
    //relative placement
    @Test
    fun simpleRelativePlacementBehaviourNodeTest() {
        val node1 = Node(
            styleName = "place",
            innerName = "waiting"
        )
        val node2 = Node(
            styleName = "transition",
            innerName = "leave critical",
            params = mutableListOf("right=of critical")
        )

        Assert.assertEquals("\\node[place] (waiting) {};", node1.printRelativePlacement())
        Assert.assertEquals("\\node[transition] (leave critical) [right=of critical] {};", node2.printRelativePlacement())
    }

    @Test
    fun simpleAddingLabelsNextToNodesTest() {
        val labeledNode = LabelledNode("{\$s\\le 3\$}", mutableListOf("red", "above"),"semaphore.north")
        Assert.assertEquals("\\node [red,above] at (semaphore.north) {\$s\\le 3\$};", labeledNode.print())
    }
}