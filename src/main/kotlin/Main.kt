import java.lang.IllegalStateException
import java.math.BigInteger;

fun main(args: Array<String>) {

}

fun capitalize(text: String): List<String> {

    text.toMutableList()
    for (i in text.indices) {
        if (i % 2 == 0) {

        } else {

        }
    }
    //TODO: Add your code!
    return listOf()
}




fun findShort(s: String): Int = s.split(" ").sortedByDescending { it.length }.take(1).get(0).length


fun prevMultOfThree(n: Int): Int? {
    if ( (n % 3 != 0) && (n < 10)) return null
    if (n % 3 == 0) return n
    return prevMultOfThree(n / 10)
}

fun getPascalRow(n: Int): List<BigInteger> {
    var prev:MutableList<BigInteger>
    var current:MutableList<BigInteger> = mutableListOf(BigInteger("1"))
    for (i in 0 until n) {
        prev = current
        current = mutableListOf(BigInteger("1"))
        for (j in 1 until prev.size) {
            current.add( prev[j-1]+prev[j])
        }
        current.add(BigInteger("1"))
    }
    return current
}

fun easyLine(n:Int): BigInteger {
    return getPascalRow(n)
        .fold(BigInteger("0")) { acc, inc -> acc + inc * inc }
}

fun String.lastChar(): Char = this.get(this.length - 1)

fun lecture1() {
    val a: Int? = null
    println(a)

    var list = mutableListOf<Int>()
    list?.removeLastOrNull()

    val b: Int? = 5
    val c: Int? = 5
    println(b === c)

    val boxed = b
    val anotherBoxed = b
    println(boxed === anotherBoxed)

    val variable: Int = 4
    val longVariable: Long = variable.toLong()


    val l = 1L + 3
    val x = (7 and 4)
    println(x)
    testSmartCast("some string")
    testSmartCast2(IntArray(5){1;2;3;4;5})
    testSmartCast2("some string 2")
    castTypeUnsafe("string")
//    castTypeUnsafe(intArrayOf())
    println(castTypeSafe("String"))
    println(castTypeSafe(intArrayOf()))
//    notImPlemented()
    val func = testUnit()
    println(func.javaClass)
    val func2 = testNothing()
    testNothing()
}


fun testNothing() {
    throw IllegalStateException()
}

fun notImPlemented() {
    TODO()
}

fun testUnit(): Unit {
    println("Unit func")
}

fun castTypeSafe(x: Any): String? {
    return x as? String
}

fun castTypeUnsafe(x: Any): String {
    return x as String
}

fun testSmartCast2(x: Any) {
    when (x) {
        is Int -> print(x + 1)
        is IntArray -> print(x.sum())
        is String -> print(x.length + 1)
    }
}
fun testSmartCast(x: Any) {
    if (x is String) {
        println(x)
    }
}

fun testFunc():Int {
    return 2
}

fun argsCount(vararg args: Any): Int {
    return args.size
}