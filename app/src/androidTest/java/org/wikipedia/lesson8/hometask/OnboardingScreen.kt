package org.wikipedia.lesson8.hometask

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.onboarding.OnboardingPageView

object OnboardingScreen : KScreen<OnboardingScreen>() {

    override val layoutId: Int = R.layout.fragment_onboarding_pager
    override val viewClass: Class<*> = OnboardingPageView::class.java

    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val pager = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::PagerItem)
        }
    )
}

class PagerItem(matcher: Matcher<View>) : KViewPagerItem<PagerItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }
    val title = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    val addLanguageButton = KButton {
        withId(R.id.addLanguageButton)
    }

    val languages = KRecyclerView(
        parent = matcher,
        builder = {
            withId(R.id.languagesList)
        },
        itemTypeBuilder = {
            itemType(::LanguageItem)
        }
    )
}

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<PagerItem>(matcher) {

}