package org.wikipedia.lesson13

import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object UiSearchScreen : UiScreen<UiSearchScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    fun clickOnResultByText(text: String) {
        UiTextView {
            withText(text)
        }.click()
    }

    fun isDisplayedResultText(text: String) {
        UiTextView {
            withText(text)
        }.isDisplayed()
    }

    fun isNotDisplayedResultText(text: String) {
        UiTextView {
            withText(text)
        }.isNotDisplayed()
    }
}