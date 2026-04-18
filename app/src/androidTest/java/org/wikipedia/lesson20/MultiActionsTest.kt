package org.wikipedia.lesson20

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson18.onboardingscreen.OnboardingScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson19.settingsscreen.SettingsScreen
import org.wikipedia.lesson20.searchscreen.SearchScreen

class MultiActionsTest : BaseTest() {
    private val text = "Hello world"

    @Test
    fun multiActionTest() {
        run {
            OnboardingScreen {
                action.multiAction(skipButton, text)
            }

            ExploreScreen {
                verify.isDisplayed(searchField)
                action.click(searchField)
            }
            SearchScreen {
                searchField {
                    action.multiAction(this, text)
                    verify.equalsWithTrim(text, this)
                }
            }
            repeat(2) {
                device.uiDevice.pressBack()
            }
            ExploreScreen {
                action.apply {
                    click(moreButton)
                    click(settingsButton)
                }
            }
            SettingsScreen.downloadWiFiBlock {
                action.multiAction(wifiToggle)
                verify.isChecked(wifiToggle)
            }
        }
    }
}