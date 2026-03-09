package org.wikipedia.lesson10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity


class AddLanguageTest : TestCase() {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyAddingLanguage() = run {
        step("Tap button add language") {
            UiOnboardingScreen.addLanguageButton.click()
        }
        step("Tap button add language") {
            WikipediaLanguagesScreen.addLanguageButton.click()
        }
        step("Verify that selected language is displayed and tap on it") {
            AddLanguagesScreen.frenchOption {
                isDisplayed()
                click()
            }
        }
        step("Verify that selected language is displayed and tap back button") {
            WikipediaLanguagesScreen {
                languageItem.isDisplayed()
                backButton.click()
            }
        }
        step("Verify that selected language is displayed in list") {
            UiOnboardingScreen {
                languageOption.isDisplayed()
            }
        }
    }
}

