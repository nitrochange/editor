fun main() {
    println("5")
    val arr = mutableListOf(1,2,3,4,5,6)
    println(arr.filter { it > 4 })
    val arr2 = mutableListOf(1,2,3,4,5,6,7,8,9,10)
    println(arr2.map { it * it })
    val arr3 = mutableListOf(1,2,3,4,5,6,7,8,9,10)
    println(arr3.filter { it % 2 == 0 }.map { it * it * it })
    val predicate = {x: Int -> x < 5}
    val arr4 = mutableListOf(1,2,3,4,5,6,7,8,9,10)
    println(arr4.all(predicate))
    println(arr4.any(predicate))
    println(arr4.count(predicate))
    println(arr.find(predicate))
    val arr5 = mutableListOf(1,2,3,-1,-1,-1,-234875,4,5,6,7,8,9,10,5,5,6,6,10)
    println(arr5.groupBy {it})
    val strings1 = listOf("a", "ab", "abc", "bc", "dcc")
    println(strings1.groupBy(String::first))

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    println(2 add 2)
    println(4 largerThan 3)

    println(alhabet1())
    println(alhabet2())
}

infix fun Int.add(x:Int): Int {
    return this + x
}

infix fun Int.largerThan(x:Int): Boolean = this > x
//with
fun alhabet1() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    toString()
}
//apply
fun alhabet2() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
}.toString()