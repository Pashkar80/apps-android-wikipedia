package org.wikipedia.lesson26.hometask

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson26.CustomTestRunWatcherInterceptor
import org.wikipedia.lesson8.hometask.OnboardingScreen
import org.wikipedia.main.MainActivity

class CustomInterceptorTest : TestCase(
    Kaspresso.Builder.advanced().apply {
        testRunWatcherInterceptors.add(CustomTestRunWatcherInterceptor())
    }
) {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyWorkCustomInterceptors() {
        testLogger.i("Test started")
        before("Название теста") {
            testLogger.i("Into section -> Before")
            device.network.toggleMobileData(false)
            device.network.toggleWiFi(false)
        }.after {
            testLogger.i("Into section -> After")
            device.network.toggleMobileData(true)
            device.network.toggleWiFi(true)
        }.run {
            testLogger.i("Into section -> Main")
            OnboardingScreen.skipButton.isDisplayed()
        }
        testLogger.i("Test finished")
    }
}