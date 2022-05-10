import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigInteger

class TestClass {
    @Test
    fun test () {
        Assert.assertEquals(2, testFunc())
    }
    @Test
    fun basicTests() {
        assertEquals(1, argsCount(100))
        assertEquals(3, argsCount(100, 2, 3))
        assertEquals(2, argsCount(32, 12))
        assertEquals(0, argsCount())
        assertEquals(1, argsCount("a string!"))
    }
    @Test
    fun anyTypeTest() {
        assertEquals(2, argsCount("a string!", Pair(1, "2")))
    }
    @Test
    fun sampleTestCases() {
        assertEquals(null, prevMultOfThree(1))
        assertEquals(null, prevMultOfThree(25))
        assertEquals(36, prevMultOfThree(36))
        assertEquals(12, prevMultOfThree(1244))
        assertEquals(9, prevMultOfThree(952406))
    }
    private fun testing(actual:BigInteger, expected:BigInteger) {
        assertEquals(expected, actual)
    }
    @Test
    fun test1() {
        testing(easyLine(7), BigInteger("3432"))
        testing(easyLine(13), BigInteger("10400600"))

    }
    @Test
    fun basicTests1() {
        assertEquals(listOf("AbCdEf", "aBcDeF"), capitalize("abcdef"))
        assertEquals(listOf("CoDeWaRs", "cOdEwArS"), capitalize("codewars"))
        assertEquals(listOf("AbRaCaDaBrA", "aBrAcAdAbRa"), capitalize("abracadabra"))
        assertEquals(listOf("CoDeWaRrIoRs", "cOdEwArRiOrS"), capitalize("codewarriors"))
    }
}