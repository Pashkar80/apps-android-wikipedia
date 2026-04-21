package org.wikipedia.lesson19.settingsscreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class TermsOfUseItem(matcher: Matcher<View>) :
    KRecyclerItem<TermsOfUseItem>(matcher) {

    val title by lazy {
        KTextView(matcher) {
            withId(android.R.id.title)
        }.name(withParent("Title"))
    }
}