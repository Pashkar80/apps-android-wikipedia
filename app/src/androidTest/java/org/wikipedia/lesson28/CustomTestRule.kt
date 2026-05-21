package org.wikipedia.lesson28

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.wikipedia.BuildConfig.INVALID_SEARCH
import org.wikipedia.BuildConfig.VALID_SEARCH
import io.qameta.allure.kotlin.Description as kotlinDescription

class CustomTestRule : TestRule {
    lateinit var testData: String
    override fun apply(
        base: Statement?,
        description: Description?
    ): Statement? {
        return object : Statement() {
            override fun evaluate() {
                val descriptionValue: String =
                    description?.getAnnotation<kotlinDescription>(kotlinDescription::class.java)!!.value
                if (descriptionValue == "valid") {
                    testData = VALID_SEARCH
                } else {
                    testData = INVALID_SEARCH
                }
                base?.evaluate()
            }
        }
    }
}