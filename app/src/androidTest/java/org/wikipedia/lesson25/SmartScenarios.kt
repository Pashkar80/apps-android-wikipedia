package org.wikipedia.lesson25

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.lesson25.screenbehavior.CloseGotIt
import org.wikipedia.lesson25.screenbehavior.ClosePlayTodayGame

class SmartScenarios(private val testContext: TestContext<*>) {

    fun closePlayTodayGame() = ClosePlayTodayGame(testContext).initBehavior()
    fun closeGotIt() = CloseGotIt(testContext).initBehavior()
}

val TestContext<*>.smartScenarios: SmartScenarios
    get() = SmartScenarios(this)
