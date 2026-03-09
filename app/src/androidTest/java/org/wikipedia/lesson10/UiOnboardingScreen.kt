package org.wikipedia.lesson10

import com.kaspersky.components.kautomator.component.common.actions.UiSwipeableActions
import com.kaspersky.components.kautomator.component.common.builders.UiViewBuilder
import com.kaspersky.components.kautomator.component.common.views.UiBaseView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

class UiViewPager(builder: UiViewBuilder.() -> Unit) :
    UiBaseView<UiViewPager>(builder),
    UiSwipeableActions

object UiOnboardingScreen : UiScreen<UiOnboardingScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val skipButton = UiButton {
        withId(this@UiOnboardingScreen.packageName, "fragment_onboarding_skip_button")
    }

    val continueButton = UiButton {
        withId(this@UiOnboardingScreen.packageName, "fragment_onboarding_forward_button")
    }

    val title = UiTextView {
        withId(this@UiOnboardingScreen.packageName, "primaryTextView")
    }

    val secondaryText = UiTextView {
        withId(this@UiOnboardingScreen.packageName, "secondaryTextView")
    }

    val addLanguageButton = UiButton {
        withId(this@UiOnboardingScreen.packageName, "addLanguageButton")
    }

    val getStartedButton = UiButton {
        withId(this@UiOnboardingScreen.packageName, "fragment_onboarding_done_button")
    }

    val pager = UiViewPager {
        withId(this@UiOnboardingScreen.packageName, "fragment_pager")
    }

    val languageOption = UiTextView {
        withId(this@UiOnboardingScreen.packageName, "option_label")
        containsText("Français")
    }

}