package core.test.command.demo

import LeftCentering
import RightCentering
import TableCaption
import TabularEnvironment
import allignment
import here
import org.junit.Test
import table
import top

class FulltablesTest {

    @Test
    fun test() {
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
}