package org.wikipedia.lesson28.hometask


import androidx.test.uiautomator.UiSelector
import io.qameta.allure.kotlin.Description
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson20.searchscreen.SearchScreen
import org.wikipedia.lesson28.CustomTestRule

class BuildConfigTest : BaseTest() {

    @get:Rule
    val customRule = CustomTestRule()

    private fun verifyValidSearch() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen {
                verify.isDisplayed(searchField)
                action.click(searchField)
            }
            SearchScreen {
                searchField {
                    action.click(this)
                    action.multiAction(this, customRule.testData)
                }
            }
            step("Verify search result") {
                device.uiDevice.findObject(
                    UiSelector().text(customRule.testData)
                ).exists()
            }
        }
    }

    private fun verifyInvalidSearch() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen {
                verify.isDisplayed(searchField)
                action.click(searchField)
            }
            SearchScreen {
                searchField {
                    action.click(this)
                    action.typeText(this, customRule.testData)
                }
            }
            step("Verify search result") {
                device.uiDevice.findObject(
                    UiSelector().text("No results")
                ).exists()
            }
        }
    }

    @Test
    @Description("valid")
    fun validSearchTest() {
        verifyValidSearch()
    }

    @Test
    @Description("invalid")
    fun invalidSearchTest() {
        verifyInvalidSearch()
    }

    @Test
    @Description("random")
    fun simpleSearchTest() {
        verifyInvalidSearch()
    }
}