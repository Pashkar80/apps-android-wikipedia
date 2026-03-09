package org.wikipedia.lesson10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class UiOnboardingTest : TestCase() {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyContinueButtonOpenNextSlide() {
        run {
            UiOnboardingScreen {
                step("Click on continue button") {
                    continueButton.click()
                }
                step("Verify text on second slide") {
                    secondaryText.containsText("Customize the feed")
                }
            }
        }
    }

    @Test
    fun verifyThirdSlide() {
        run {
            UiOnboardingScreen {
                step("Swipe left twice and verify text on third slide") {
                    repeat(2) {
                        pager.swipeLeft()
                    }
                    title.containsText("Reading lists with sync")
                }
            }
        }
    }

    @Test
    fun verifyFourthSlide() {
        run {
            UiOnboardingScreen {
                step("Click on continue button 3 times and verify text on forth slide") {
                    repeat(3) {
                        continueButton.click()
                    }
                    title.containsText("Data & Privacy")
                }
            }
        }
    }

    @Test
    fun verifyGetStartedButtonDisplayed() {
        run {
            UiOnboardingScreen {
                step("Open forth slide with swipe and verify that button get started displayed") {
                    repeat(3) {
                        pager.swipeLeft()
                    }
                    getStartedButton.isDisplayed()
                }
            }
        }
    }
}
