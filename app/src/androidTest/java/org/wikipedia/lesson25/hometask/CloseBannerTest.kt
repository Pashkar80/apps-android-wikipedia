package org.wikipedia.lesson25.hometask

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson22.homework.BottomSheet
import org.wikipedia.lesson23.screen.ArticleScreen

class CloseBannerTest : BaseTest() {

    @Test
    fun closeBannersTest() {
        run {
            action {
                click(OnboardingScreen.skipButton)
                ExploreScreen.featuredArticleBlock(1) {
                    click(this)
                }
                click(ArticleScreen.themeButton)
            }
            BottomSheet.themeWidget {
                verify.isDisplayed(this)
            }
        }
    }
}