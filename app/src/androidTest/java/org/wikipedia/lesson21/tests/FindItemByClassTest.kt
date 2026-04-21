package org.wikipedia.lesson21.tests

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify

class FindItemByClassTest : BaseTest() {

    @Test
    fun verifyItemByClassAndIndex() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen {
                featuredArticleBlock(1) {
                    verify.isDisplayed(this)
                }
            }
        }
    }
}