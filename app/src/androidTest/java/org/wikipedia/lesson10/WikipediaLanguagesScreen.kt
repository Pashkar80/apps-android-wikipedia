package org.wikipedia.lesson10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.screen.UiScreen

object WikipediaLanguagesScreen : UiScreen<WikipediaLanguagesScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val addLanguageButton = UiButton {
        withId(this@WikipediaLanguagesScreen.packageName, "wiki_language_title")
        withText("Add language")
    }

    val languageItem = UiView {
        withId(this@WikipediaLanguagesScreen.packageName, "wiki_language_title")
        withText("Français")
    }

    val backButton = UiView {
        withContentDescription("Navigate up")
    }
}
