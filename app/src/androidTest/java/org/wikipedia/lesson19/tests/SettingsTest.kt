package org.wikipedia.lesson19.tests

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson19.settingsscreen.SettingsScreen

class SettingsTest : BaseTest() {

    @Test
    fun verifyToggle() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen {
                action.apply {
                    click(moreButton)
                    click(settingsButton)
                }
            }
            SettingsScreen.showLinkPreviewsBlock {
                action.click(linkPreviewsToggle)
                verify.isNotChecked(linkPreviewsToggle)
            }
        }
    }
}