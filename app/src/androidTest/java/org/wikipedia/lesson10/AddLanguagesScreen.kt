package org.wikipedia.lesson10

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen

object AddLanguagesScreen : UiScreen<AddLanguagesScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val frenchOption = UiView { withText("French") }

}