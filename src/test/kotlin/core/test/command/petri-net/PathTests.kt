package core.test.command.`petri-net`

import com.core.tikz.util.Path
import org.junit.Assert
import org.junit.Test

class PathTests {

    @Test
    fun pathForPetriNetsSimpleTest() {
        val path = Path(
            points = mutableListOf(),
            params = mutableListOf()
        )
        Assert.assertEquals("asf", path.toTex())
    }
}