package org.wikipedia.lesson22

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class NoSearchWidget(builder: ViewBuilder.() -> Unit) : KWidget<NoSearchWidget>(builder) {

    val image by lazy {
        KImageView(matcher) {
            withId(R.id.history_empty_image)
        }.name(withParent("Image"))
    }

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.history_title)
        }.name(withParent("Title"))
    }

    val description by lazy {
        KTextView(matcher) {
            withId(R.id.history_list)
        }.name(withParent("History List"))
    }
}