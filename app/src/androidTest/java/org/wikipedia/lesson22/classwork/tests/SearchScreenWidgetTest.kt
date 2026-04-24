package org.wikipedia.lesson22.classwork.tests

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson20.searchscreen.SearchScreen
import org.wikipedia.lesson21.navbar.NavBarScreen

class SearchScreenWidgetTest : BaseTest() {

    @Test
    fun verifyWidgetsOnSearchScreen() {
        run {
            action {
                click(OnboardingScreen.skipButton)
                click(NavBarScreen.searchButton)
            }
            verify {
                SearchScreen {
                    isDisplayed(searchWidget)
                }
                SearchScreen.noRecentlyWidget {
                    isDisplayed(this)
                    // hasText(title, "History")
                    isDisplayed(image)
                    isDisplayed(description)
                }
            }
        }
    }
}