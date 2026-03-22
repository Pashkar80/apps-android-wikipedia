package org.wikipedia.lesson13

import androidx.test.espresso.web.webdriver.Locator.CSS_SELECTOR
import androidx.test.espresso.web.webdriver.Locator.XPATH
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.lesson8.hometask.ExplorerScreen
import org.wikipedia.lesson8.hometask.OnboardingScreen
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase() {
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testVerifyArticle() {
        run {
            OnboardingScreen.skipButton.click()
            ExplorerScreen.searchField.click()
            Thread.sleep(5000)
            SearchScreen {
                searchField {
                    click()
                    typeText("98th Academy Awa")
                }
                Thread.sleep(5000)
            }
            UiSearchScreen.clickOnResultByText("98th Academy Awards")
            ExplorerScreen.closeButton.click()
            Thread.sleep(3000)
            ArticleScreen.webView {
                withElement(CSS_SELECTOR, "#References") {
                    scroll()
                    hasText("References")
                }
                withElement(
                    XPATH,
                    "//a[.//text()='5']"
                ) {
                    scroll()
                    click()
                }
            }
            Thread.sleep(5000)
            ReferencePopupScreen {
                title.hasText("Reference ")
                referenceId.hasText("5.")
            }
            device.uiDevice.pressBack()
            ArticleScreen.webView {
                withElement(
                    XPATH, "(//a[@class='mw-redirect'])[2]"
                ) {
                    scroll()
                    click()
                }
            }
            ArticlePopupScreen().readArticleButton.click()
            Thread.sleep(5000)
            ArticleScreen.webView {
                withElement(CSS_SELECTOR, "#References") {
                    scroll()
                    hasText("References")
                }

            }
        }
    }
}