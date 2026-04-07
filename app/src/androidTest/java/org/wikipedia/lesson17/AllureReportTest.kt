package org.wikipedia.lesson17

import org.junit.Test
import org.wikipedia.lesson8.hometask.ExplorerScreen
import org.wikipedia.lesson8.hometask.OnboardingScreen

class AllureReportTest : BaseTest() {

    @Test
    fun verifyButtonDisplayed() {
        run {
            OnboardingScreen {
                step("Verify that button Skip displayed") {
                    skipButton.isDisplayed()
                }
                step("Verify text in button") {
                    continueButton.hasText("Continue")
                }
            }
        }

    }

    @Test
    fun verifyText() {
        run {
            step("Click on Skip button") {
                OnboardingScreen.skipButton.click()
            }
            step("Verify that search field is not displayed") {
                ExplorerScreen.searchField.isNotDisplayed()
            }
        }
    }
}