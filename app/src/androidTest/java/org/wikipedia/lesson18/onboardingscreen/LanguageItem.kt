package org.wikipedia.lesson18.onboardingscreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher

class LanguageItem(matcher: Matcher<View>) : KRecyclerItem<LanguageItem>(matcher),
    TextViewAssertions