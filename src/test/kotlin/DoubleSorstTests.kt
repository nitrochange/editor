package com.codewars.a.partridge

import java.util.ArrayList
import java.util.Arrays
import junit.framework.TestCase
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

/**
 * @author ruslan.lopez
 */
@RunWith(Parameterized::class)
class DoubleSortTest(a:Array<Any>, expResult:Array<Any>) {
    private val a:Array<Any>
    private val expResult:Array<Any>
    init{
        this.a = a
        this.expResult = expResult
    }
    /**
     * Test of dbSort method, of class DoubleSort.
     */
    @Test
    fun basicTests() {
        val result = DoubleSort.dbSort(a)
        assertArrayEquals(expResult, result)
    }
    companion object {
        @JvmStatic
        @Parameters
        @Throws(Throwable::class)
        fun data():Iterable<Array<Any>> {
            return Arrays.asList<Array<Any>>(*arrayOf<Array<Any>>(arrayOf<Any>(arrayOf<Int>(6, 2, 3, 4, 5), arrayOf<Int>(2, 3, 4, 5, 6)), arrayOf<Any>(arrayOf<Int>(14, 32, 3, 5, 5), arrayOf<Int>(3, 5, 5, 14, 32)), arrayOf<Any>(arrayOf<Int>(1, 2, 3, 4, 5), arrayOf<Int>(1, 2, 3, 4, 5)), arrayOf<Any>(arrayOf<Any>("Banana", "Orange", "Apple", "Mango", 0, 2, 2), arrayOf<Any>(0, 2, 2, "Apple", "Banana", "Mango", "Orange")), arrayOf<Any>(arrayOf<Any>("C", "W", "W", "W", 1, 2, 0), arrayOf<Any>(0, 1, 2, "C", "W", "W", "W")),
                arrayOf<Any>(arrayOf<Any>("Apple",46,"287",574,"Peach","3","69",78,"Grape","423"), arrayOf<Any>(46, 78, 574, "287", "3", "423", "69", "Apple", "Grape", "Peach"))
            ))
        }
    }
}