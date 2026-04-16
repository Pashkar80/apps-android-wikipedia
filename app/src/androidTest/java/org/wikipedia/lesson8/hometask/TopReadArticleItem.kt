package org.wikipedia.lesson8.hometask

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class TopReadArticleItem(matcher: Matcher<View>) : KRecyclerItem<TopReadArticleItem>(matcher) {

    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.name(withParent("Title"))
    }

    val subTitle by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.name(withParent("Sub Title"))
    }

    val graph by lazy {
        KView(matcher) {
            withId(R.id.view_list_card_item_graph)
        }.name(withParent("Graph"))
    }

    val count by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_pageviews)
        }.name(withParent("Count"))
    }

    val numberView by lazy {
        KTextView(matcher) {
            withId(R.id.numberView)
        }.name(withParent("Number View"))
    }

    val image by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_image)
        }.name(withParent("Image"))
    }
}