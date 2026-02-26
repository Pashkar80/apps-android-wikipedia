package org.wikipedia.lesson8.hometask

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class TopReadArticleItem(matcher: Matcher<View>) : KRecyclerItem<TopReadArticleItem>(matcher) {

    val title = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }
    val subTitle = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }
    val graph = KView(matcher) {
        withId(R.id.view_list_card_item_graph)
    }
    val count = KTextView(matcher){
        withId(R.id.view_list_card_item_pageviews)
    }
    val numberView = KTextView(matcher){
        withId(R.id.numberView)
    }

}