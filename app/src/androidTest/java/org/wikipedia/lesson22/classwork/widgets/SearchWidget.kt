package org.wikipedia.lesson22.classwork.widgets

import com.google.android.material.textview.MaterialTextView
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class SearchWidget(builder: ViewBuilder.() -> Unit) : KWidget<SearchWidget>(builder) {

    val searchIcon by lazy {
        KView(matcher) {
            withContentDescription("Search Wikipedia")
        }.name(withParent("Search Icon"))
    }

    val searchText by lazy {
        KTextView(matcher) {
            isInstanceOf(MaterialTextView::class.java)
        }.name(withParent("Search Text"))
    }

    val voiceIcon by lazy {
        KImageView(matcher) {
            withId(R.id.voice_search_button)
        }.name(withParent("Voice Icon"))
    }
}