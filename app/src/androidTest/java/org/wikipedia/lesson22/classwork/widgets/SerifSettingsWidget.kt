package org.wikipedia.lesson22.classwork.widgets

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class SerifSettingsWidget(builder: ViewBuilder.() -> Unit) : KWidget<SerifSettingsWidget>(builder) {

    val decreaseTextSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonDecreaseTextSize)
        }.name(withParent("Decrease Text Size Button"))
    }

    val increaseTextSizeButton by lazy {
        KTextView(matcher) {
            withId(R.id.buttonIncreaseTextSize)
        }.name(withParent("Increase Text Size Button"))
    }

    val textSize by lazy {
        KTextView(matcher) {
            withId(R.id.text_size_percent)
        }.name(withParent("Text Size Percent"))
    }
}