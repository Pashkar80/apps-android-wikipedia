package org.wikipedia.lesson18.explorerscreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson19.ext.invokeWithText
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent
import org.wikipedia.lesson8.hometask.TopReadArticleItem

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<TopReadItem>(matcher) {

    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.name(withParent("Header"))
    }

    val menu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.name(withParent("Menu"))
    }

    val moreTopReadButton by lazy {
        KTextView(matcher) {
            withId(R.id.footerActionButton)
        }.name(withParent("Button More Top Read"))
    }

    val topReadArticleRecycler by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { R.id.view_list_card_list },
            itemTypeBuilder = {
                itemType(::TopReadArticleItem)
            }
        ).name(withParent("Top Read Article Recycler"))
    }


    fun topReadArticleItemByText(text: String, fnc: TopReadArticleItem.() -> Unit) {
        topReadArticleRecycler.invokeWithText(text, fnc)
    }
}