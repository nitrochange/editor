open class MyView{
    var counter = 0 // the initializer assigns the backing field directly
        set(value) {
            if (value >= 0)
                field = value
                print(field)
            // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
        }
}
fun main() {
    val helloWorld = object {
        val hello = "Hello"
        val world = "World"
        // object expressions extend Any, so `override` is required on `toString()`
        override fun toString() = "$hello $world"
    }
    funcReceivedAny(
        object : MyView() {
             fun mouseClicked(e: Any) { /*...*/ }

             fun mouseEntered(e: Any) { /*...*/ }
        }
    )
    println(    helloWorld.toString())
}
fun funcReceivedAny(a: Any) {

}
class C {
    private fun getObject() = object {
        val x: String = "x"
    }

    fun printX() {
        println(getObject().x)
    }
}