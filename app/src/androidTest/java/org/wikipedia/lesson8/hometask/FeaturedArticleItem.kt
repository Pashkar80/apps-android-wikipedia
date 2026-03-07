package org.wikipedia.lesson8.hometask

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.R

class FuturedArticleItem(matcher: Matcher<View>) : KRecyclerItem<FuturedArticleItem>(matcher) {

    val header = KView(matcher) {
        withId(R.id.view_featured_article_card_header)
    }

    val container = KView(matcher) {
        withId(R.id.view_featured_article_card_content_container)
    }

    val footer = KView(matcher) {
        withId(R.id.view_featured_article_card_footer)
    }
}