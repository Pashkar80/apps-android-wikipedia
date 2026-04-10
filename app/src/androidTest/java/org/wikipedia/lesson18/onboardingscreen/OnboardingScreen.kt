package org.wikipedia.lesson18.onboardingscreen

import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson19.ext.invokeByIndex
import org.wikipedia.lesson19.ext.name

object OnboardingScreen : NamedScreen<OnboardingScreen>() {

    override val screenName = "Onboarding Screen"
    override val layoutId = null
    override val viewClass = null

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }.name(withParent("Button Skip"))

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }.name(withParent("Button Continue"))

    val pager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::PagerItem)
        }
    ).name(withParent("Slider"))

    fun page(index: Int, fnc: PagerItem.() -> Unit) {
        pager.invokeByIndex(index, fnc)
    }
}