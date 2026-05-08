package org.wikipedia.lesson22.homework

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson23.screen.ArticleScreen

class TextSizeSettingTest : BaseTest() {

    @Test
    fun verifyTextSizeSettingButton() {
        run {
            action {
                click(OnboardingScreen.skipButton)
                ExploreScreen.featuredArticleBlock(1) {
                    click(this)
                }
                click(ArticleScreen.themeButton)
            }
            BottomSheet.serifSettingWidget {
                verify.isDisplayed(this)
                action.click(increaseTextSizeButton)
                verify.hasText(textSize, "110%")
                repeat(2) {
                    action.click(decreaseTextSizeButton)
                }
                verify.hasText(textSize, "90%")
            }

        }
    }
}