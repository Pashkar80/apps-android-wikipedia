package org.wikipedia.lesson19.tests

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify

class TopReadTest : BaseTest() {

    @Test
    fun verifyImage() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen.topReadBlock {
                thirdArticle {
                    verify.isDisplayed(image)
                }
            }
        }
    }
}