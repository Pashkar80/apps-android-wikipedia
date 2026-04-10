package org.wikipedia.lesson18.explorerscreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {

    val customizeButton by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_action_positive)
        }.name(withParent("Button Customize"))
    }

    val gotItButton by lazy {
        KButton(matcher) {
            withId(R.id.view_announcement_action_negative)
        }.name(withParent("Got It Customize"))
    }

    val customizeImage by lazy {
        KImageView(matcher) {
            withId(R.id.view_announcement_header_image)
        }.name(withParent("Customize Image"))
    }

    val describeText by lazy {
        KImageView(matcher) {
            withId(R.id.view_announcement_text)
        }.name(withParent("Describe Text"))
    }
}