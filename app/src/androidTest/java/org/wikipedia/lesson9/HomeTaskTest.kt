package org.wikipedia.lesson9

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.feed.announcement.AnnouncementCardView
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.lesson8.hometask.CustomizeFeedItem
import org.wikipedia.lesson8.hometask.CustomizeFeedScreen
import org.wikipedia.lesson8.hometask.CustomizeItem
import org.wikipedia.lesson8.hometask.ExplorerScreen
import org.wikipedia.lesson8.hometask.FuturedArticleItem
import org.wikipedia.lesson8.hometask.OnboardingScreen
import org.wikipedia.main.MainActivity

class HomeTaskTest : TestCase() {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun verifyHideFeaturedArticleBlock() {
        run("Verify hide featured article block") {
            OnboardingScreen {
                step("Click skip button") {
                    skipButton.click()
                }
            }
            ExplorerScreen {
                step("Click customize button") {
                    item.childWith<FuturedArticleItem> {
                        isInstanceOf(FeaturedArticleCardView::class.java)
                    } perform {
                        isDisplayed()
                    }
                    item.childWith<CustomizeItem> {
                        isInstanceOf(AnnouncementCardView::class.java)
                    } perform {
                        customizeButton.click()
                    }
                }

            }
            CustomizeFeedScreen {
                step("Switch of Featured Article block") {
                    item.childWith<CustomizeFeedItem> {
                        withDescendant { withText("Featured article") }
                    } perform {
                        toggle.click()
                        toggle.isNotChecked()
                    }
                    backButton.click()
                }
            }
            ExplorerScreen {
                step("Verify that Featured Article block hide") {
                    logo.isDisplayed()
                    item.childWith<FuturedArticleItem> {
                        withDescendant { withText("Featured article") }
                    } perform {
                        doesNotExist()
                    }
                }
            }
        }
    }
}