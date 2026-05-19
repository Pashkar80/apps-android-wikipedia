package org.wikipedia.lesson28

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.BuildConfig.CANONICAL_NAME
import org.wikipedia.BuildConfig.LOCALE_NAME
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson24.screen.AddLanguageScreen
import org.wikipedia.lesson24.screen.WikipediaLanguageScreen
import org.wikipedia.main.MainActivity

class AddLanguageTest : BaseTest() {

    @get:Rule(0)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule(1)
    val kakaoRule = KakaoComposeTestRule(composeTestRule, true)

    @Test
    fun verifyThatLanguageAdded() {
        333
        run {
            action.click(OnboardingScreen.addLanguageButton)
            action.click(WikipediaLanguageScreen.addLanguageButton)
            AddLanguageScreen.getFrenchItem {
                verify.assertTrimmedTextIsEquals(localeName, LOCALE_NAME)
                verify.assertTrimmedTextIsEquals(canonicName, CANONICAL_NAME)
                action.clickIfEnabled(localeName)
            }
            action.click(WikipediaLanguageScreen.backButton)
            OnboardingScreen.page(0) {
                languageBlockByIndex(1) {
                    verify.hasText(this, "2.\t\tFrançais")
                }
            }
        }
    }
}