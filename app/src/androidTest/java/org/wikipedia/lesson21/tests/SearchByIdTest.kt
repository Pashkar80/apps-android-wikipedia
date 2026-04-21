package org.wikipedia.lesson21.tests

import org.junit.Test
import org.wikipedia.R
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson19.settingsscreen.SettingsScreen
import org.wikipedia.lesson21.navbar.NavBarScreen

class SearchByIdTest : BaseTest() {

    @Test
    fun verifySearchById() {
        run {
            action.click(OnboardingScreen.skipButton)
            NavBarScreen {
                action.apply {
                    click(moreButton)
                    click(settingsButton)
                }
            }
            SettingsScreen {
                collapseTablesItemBlock(1, R.id.switchWidget) {
                    action.click(collapseTablesToggle)
                    verify.isNotChecked(collapseTablesToggle)
                }
                termsOfUseItemBlock(2, R.id.right_icon) {
                    verify.hasText(title, "Terms of use")
                }
            }
        }
    }
}