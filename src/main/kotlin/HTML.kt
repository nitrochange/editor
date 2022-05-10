class HTML {
    fun body(): Unit {}
}

fun html(init: HTML.() -> Unit):HTML {
    val html = HTML() // создаем receiver object
    html.init()
    return html
}
fun htmlToString(init: HTML.() -> String): String {
    val html = HTML()
    return html.init()
}
fun generateTable(fill: () -> String):String {
    return "\\begin{table}[]" + fill() + "\\end{table}"
}
fun generateInner(): () -> String = {
    "\\begin{tabular}{lllll}" +"\n" + "\\end{tabular}"
}

//\begin{table}[]
//\begin{tabular}{lllll}
//&  &  &  &  \\
//&  &  &  &  \\
//&  &  &  &  \\
//&  &  &  &
//\end{tabular}
//\end{table}
abstract class TableCentering {
    abstract override fun toString(): String
}
class LeftCentering: TableCentering() { override fun toString() = "\\flushleft"}
class RightCentering: TableCentering() { override fun toString() = "\\flushright"}
class CenterCentering: TableCentering() { override fun toString() = "\\centering"}

class Table(val allignment: String,
            var caption: TableCaption,
            var centering: TableCentering,
            var environment: TabularEnvironment) {
    var rows: MutableList<String>
    init {
        rows = mutableListOf("1 & 2 \\\\\n", "3 & 4")
    }
    fun render(builder: StringBuilder) {
        builder.append("\\begin{table}[${allignment}]")
        builder.append("\n")
        builder.append(centering.toString())
        builder.append("\n")
        builder.append(caption.getCaption())
        builder.append("\n")
        builder.append(environment.getEnvironmentBegin())
        builder.append("{|c|c|}")
//        builder.append(environment.getBegin())
        builder.append("\n")
        rows.forEach {builder.append(it)}
        builder.append("\n")
        builder.append(environment.getEnvironmentEnd())
//        builder.append(environment.getEnd())
        builder.append("\n")
        builder.append("\\end{table}")
    }

    fun toTex(): String {
        val builder = StringBuilder()
        render(builder)
        return builder.toString()
    }
}
abstract class TableEnvironment {
    protected abstract fun getName(): String
    fun getEnvironmentBegin(): String {
        return "\\begin{${getName()}}"
    }
    fun getEnvironmentEnd(): String {
        return "\\end{${getName()}}"
    }
}
class TabularEnvironment: TableEnvironment() {
    override fun getName(): String {
        return "tabular"
    }

}
class TabularXEnvironment: TableEnvironment() {
    override fun getName(): String {
        return "tabularX"
    }
}
class WrapTableEnvironment: TableEnvironment() {
    override fun getName(): String {
        return "wraptable"
    }

}
//open operator fun TabularEnvironment.unaryPlus
fun tabular(init: TabularEnvironment.() -> Unit): TabularEnvironment {
    val tabularEnvironment = TabularEnvironment()
    tabularEnvironment.init()
    return tabularEnvironment
}
fun text():TabularEnvironment.() -> Unit {
    return {}
}
fun text1():Table.() -> Unit {
    return {}
}
class TableCaption(val text: String) {
    fun getCaption():String = "\\caption{$text}"
}
fun leftAllignment() {

}
fun table(
    allignment: String,
    centering: TableCentering,
    caption: TableCaption,
    environment: TabularEnvironment, init: Table.() -> Unit): Table {

    val table = Table(
        allignment = allignment,
        caption = caption,
        centering = centering,
        environment = environment)
    table.init()
    return table
}
fun here(): String = "!hbt"
fun top(): String = "!h"
fun bottom(): String = "b"
fun allignment(func: () -> String): String = func()
//val func: HTML.() -> String = {"some html generated"}
//html { body() }
//println(htmlToString(func))
//println(generateTable (generateInner()))


// table (
// allignment {
//      here()|bottom()|top()
// }
// leftcentering()
// caption {
//       +"caption text"
// }
//
// tabular {
//
// }

// )



fun main() {
    val table1 = table(
        allignment {
            here()
        },
        centering = LeftCentering(),
        caption = TableCaption("Caption text"),
        environment = TabularEnvironment()
    ) {

    }

    println(table1.toTex())

    val table2 = table(
        allignment {
            top()
        },
        centering = RightCentering(),
        caption = TableCaption("Another text"),
        environment = TabularEnvironment()
    ) {

    }

    print(table2.toTex())
}

