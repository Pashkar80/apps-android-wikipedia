package org.wikipedia.lesson9

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson8.hometask.OnboardingScreen
import org.wikipedia.main.MainActivity

class SimpleTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkOnboardingScreen() {
        run("Continue button displayed on onboarding screen") {
            OnboardingScreen {
                continueButton {
                    isDisplayed()
                }
                pager.isDisplayed()
            }
        }
    }
}