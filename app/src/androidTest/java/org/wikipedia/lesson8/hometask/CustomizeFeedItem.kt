package org.wikipedia.lesson8.hometask

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.switch.KSwitch
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeFeedItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeFeedItem>(matcher) {

    val toggle = KSwitch(matcher) {
        withId(R.id.feed_content_type_checkbox)
    }
}