package org.wikipedia.lesson22.homework

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify

class HomeTaskTest : BaseTest() {

    @Test
    fun verifyWidgetsOnSearchScreen() {
        run {
            action.click(OnboardingScreen.skipButton)
            action {
                ExploreScreen {
                    featuredArticleBlock(1) {
                        click(this)
                        click(closeButton)
                        click(themeButton)
                    }
                }
            }
            BottomSheet {
                serifSettingWidget {
                    verify.isDisplayed(this)
                    action.click(increaseTextSizeButton)
                    verify.hasText(textSize, "110%")
                    repeat(2) {
                        action.click(decreaseTextSizeButton)
                    }
                    verify.hasText(textSize, "90%")
                }
                themeWidget {
                    verify.isDisplayed(this)
                    action.click(matchSystemThemeSwitch)
                    verify.apply {
                        isEnabled(buttonThemeDark)
                        isEnabled(buttonThemeBlack)
                    }
                    action.click(matchSystemThemeSwitch)
                    verify.apply {
                        isDisabled(buttonThemeDark)
                        isDisabled(buttonThemeBlack)
                    }
                }
            }
        }
    }
}