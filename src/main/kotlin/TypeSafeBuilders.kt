fun main() {
    val obj = object {
        var field : String = ""
        var filed2: Int = 0
    }


    val sum: Int.(Int) -> Int = {x -> plus(x)}
    val sum2 = fun Int.(other: Int): Int = this + other
    println(applysum(sum, 5))
    val complexfunc: Int.(String) -> Unit = {
        println(it)
    }
    moreComplexApply(complexfunc, "Just Simple String")
    val doubleArgsFunc: Int.(String, String) -> Unit =
        {first: String, second:String -> println(first + second + this)}
    doubleArgApply(doubleArgsFunc, 5)
    val emptyFunc: Int.() -> Int = { 5}
    println(emptyFunc(emptyFunc, 6))

}

fun emptyFunc(func: Int.() -> Int, arg: Int): Int {
    return arg.func()
}

fun doubleArgApply(func: Int.(String, String) -> Unit, arg: Int) {
    arg.func("left", "right")
}

fun applysum(func: Int.(Int) -> Int, variable: Int): Int {
    return variable.func(variable)
}
fun moreComplexApply(func: Int.(String) -> Unit, variable: String) {
    val variable1: Int = 5
    return variable1.func(variable)
}