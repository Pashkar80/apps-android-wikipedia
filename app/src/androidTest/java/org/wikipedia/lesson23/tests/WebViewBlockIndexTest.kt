package org.wikipedia.lesson23.tests

import org.junit.Test
import org.wikipedia.lesson17.BaseTest
import org.wikipedia.lesson18.explorerscreen.ExploreScreen
import org.wikipedia.lesson19.ext.action
import org.wikipedia.lesson19.ext.verify
import org.wikipedia.lesson23.screen.ArticleScreen
import org.wikipedia.lesson8.hometask.ExplorerScreen
import org.wikipedia.lesson8.hometask.OnboardingScreen

class WebViewBlockIndexTest : BaseTest() {

    @Test
    fun verifyBlockIndex() {
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
            ArticleScreen {
                action.click(references)
                verify.apply {
                    referenceItem(2) {
                        isDisplayed(index)
                        hasText(index, "[2]")
                    }
                }
            }
        }
    }
}