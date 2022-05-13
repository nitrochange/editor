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
            var environment: TableEnvironment) {
    var rows: MutableList<String>
    var utilCommands: MutableList<String> = mutableListOf()
    init {
        rows = mutableListOf("1 & 2 \\\\\n", "3 & 4")
    }
    constructor():this("",TableCaption(""), LeftCentering(),TabularEnvironment()) {

    }

    fun caption(init: TableCaption.() -> Unit) {
        val tableCaption = TableCaption()
        tableCaption.init()
        this.caption = tableCaption
    }
    fun hline(fake: () -> Unit) {
        //todo апдейт utilCommands
    }
    fun headings(headings: () -> Unit ) {

    }
    fun boldfont(init: String.() -> Unit) {

    }

    fun endfirsthead(fake: () -> Unit) {

    }
    fun addcontinuelabel(init: (newPage: Boolean) -> Unit) {

    }
    fun addlabeldublications(fake: () -> Unit) {

    }
    fun content(init: () -> Unit) {

    }
    fun row(init: () -> Unit) {}
    fun repeatcontent(init: () -> Unit) {

    }
    fun leftcentering(init: () -> Unit) {}
    fun rightcentering(init: () -> Unit) {}
    fun centering(init: () -> Unit) {}
    fun wrappingtext(init: () -> Unit) {}
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
class Longtable1: TableEnvironment() {
    override fun getName() = "longtable"
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
abstract class CommandWithText() {
    private var text: String = ""
    operator fun String.unaryPlus(){
        text = ""
    }
}
class TableCaption(val text: String) {
    constructor(): this("")
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
fun caption(): TableCaption {
    return TableCaption("")
}

fun table(init: Table.() -> Unit): Table {
    val table = Table()
    table.init()
    return table
}
fun longtable(init: Table.() -> Unit): Table {
    val longTable = Table()
    longTable.init()
    return longTable
}
fun wraptable(init: Table.() -> Unit): Table {
    val wraptable = Table()
    wraptable.init()
    return wraptable
}
fun settings(init: () -> Unit) {}


fun main() {
    val table1 = table(
        allignment {
            here()
        },
        LeftCentering(),
        TableCaption("Caption text"),
        TabularEnvironment()
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

