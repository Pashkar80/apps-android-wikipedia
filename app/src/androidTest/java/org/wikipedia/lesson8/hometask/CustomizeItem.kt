package org.wikipedia.lesson8.hometask

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import org.wikipedia.R
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher

class CustomizeItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeItem>(matcher) {

    val customizeButton = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val gotItButton = KButton(matcher) {
        withId(R.id.view_announcement_action_negative)
    }

    val customizeImage = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }
    val describeText = KImageView(matcher) {
        withId(R.id.view_announcement_text)
    }
}