package org.wikipedia.lesson8.hometask

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class InTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val menu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val topReadArticleRecycler = KRecyclerView(
        parent = matcher,
        builder = { R.id.view_list_card_header },
        itemTypeBuilder = {
            itemType(::InTheNewsArticleItem)
        }
    )
}