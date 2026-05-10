package org.wikipedia.lesson26

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.main.MainActivity

class ClassWorkTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.advanced().apply {
        viewActionWatcherInterceptors.add(MyViewActionWatcherInterceptor())
        viewAssertionWatcherInterceptors.add(MyViewAssertionWatcherInterceptor())
    }
) {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun exampleTest() {
        run {
            step("Step") {
                OnboardingScreen.skipButton {
                    isDisplayed()
                    click()
                }
            }
        }
    }
}