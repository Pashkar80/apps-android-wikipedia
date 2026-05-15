package org.wikipedia.lesson27


import android.util.Log
import io.qameta.allure.kotlin.AllureId
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class CustomTestRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        Log.i("KASPRESSO", description!!.displayName)
        return object : Statement() {
            override fun evaluate() {
                val annot = description.getAnnotation<AllureId>(AllureId::class.java).value
                if (annot !in Config.testCases) {
                    throw IllegalStateException("Not correct testcase")
                }
                try {
                    base?.evaluate()
                } catch (e: Throwable) {
                    Log.i("KASPRESSO", e.message ?: "NULL")
                }
                Log.i("KASPRESSO", "Custom Rule  - TEST RULE FINISHED")
            }
        }
    }
}

class CustomRuleTest() {

    @get:Rule
    val customRule = CustomTestRule()

    @Test
    @AllureId("4")
    fun verifyCustomRule() {
        Log.i("KASPRESSO", "Log from test")
        Assert.assertTrue("SHUT DOWN", false)

    }
}


object Config {
    val testCases = listOf("1", "2", "3")
}