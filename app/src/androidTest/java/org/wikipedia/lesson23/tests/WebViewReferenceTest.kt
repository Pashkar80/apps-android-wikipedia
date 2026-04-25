package org.wikipedia.lesson23.tests

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson23.screen.ArticleScreen
import org.wikipedia.lesson8.hometask.ExplorerScreen
import org.wikipedia.lesson8.hometask.OnboardingScreen

class WebViewReferenceTest : BaseTest() {

    @Test
    fun verifyReferences() {
        run {
            action.click(OnboardingScreen.skipButton)
            ExploreScreen {
                topReadBlock {
                    thirdArticle {
                        verify.isDisplayed(this)
                        action.click(this)
                    }
                }
                action.click(ExplorerScreen.closeButton)

            }
            verify {
                ArticleScreen {
                    isDisplayed(title)
                    isDisplayed(referencesList)
                    referenceItem(1) {
                        isDisplayed(index)
                        hasText(index, "[1]")
                    }
                }
            }
        }
    }
}