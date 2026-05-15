package org.wikipedia.lesson27.homework

import org.junit.AssumptionViolatedException
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class DeprecateTestRule : TestRule {
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        return object : Statement() {
            override fun evaluate() {
                val deprecated = description!!.annotations.any { it is Deprecated } == true
                if (deprecated) {
                    throw AssumptionViolatedException("SKIP test")
                }
                base!!.evaluate()
            }

        }
    }
}