package org.wikipedia.lesson27.homework

import android.util.Log
import org.junit.Rule
import org.junit.Test

class HomeTaskTests {

    @get:Rule
    val customRule = DeprecateTestRule()

    @Test
    fun testOne() {
        Log.i("KASPRESSO", "Test -> one")
    }

    @Test
    @Deprecated("Need update")
    fun testTwo() {
        Log.i("KASPRESSO", "Test -> two")
    }

    @Test
    fun testThree() {
        Log.i("KASPRESSO", "Test -> three")
    }
}