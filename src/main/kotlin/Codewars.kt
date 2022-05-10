object DoubleSort {
    fun dbSort(a:Array<Any>):Array<Any> {
        val ints = mutableListOf<Int>()
        val strings = mutableListOf<String>()
        a.forEach { when(it) {
            is String -> strings.add(it)
            is Int -> ints.add(it)
        } }
        val result = Array<Any>(a.size) {}
        for (i in 0 until ints.size) {
            result.set(i, ints.sorted()[i] as Any)
        }
        for (i in 0 until  strings.size) {
            result.set(i + ints.size, strings.sorted()[i] as Any)
        }
        return result
    }
}