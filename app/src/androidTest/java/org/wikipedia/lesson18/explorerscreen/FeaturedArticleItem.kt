package org.wikipedia.lesson18.explorerscreen

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class FeaturedArticleItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleItem>(matcher) {

    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_featured_article_card_header)
        }.name(withParent("Header"))
    }

    val container by lazy {
        KView(matcher) {
            withId(R.id.view_featured_article_card_content_container)
        }.name(withParent("Container"))
    }

    val footer by lazy {
        KView(matcher) {
            withId(R.id.view_featured_article_card_footer)
        }.name(withParent("Footer"))
    }
}