package org.wikipedia.lesson22

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify

class WidgetTest : BaseTest() {

    @Test
    fun verifySearchWidget() {
        run {
            action.click(OnboardingScreen.skipButton)
            verify {
                ExploreScreen.searchWidget {
                    isDisplayed(this)
                    isDisplayed(searchIcon)
                    hasText(searchText, "Search Wikipedia")
                    isDisplayed(voiceIcon)
                }
            }
        }
    }
}