package org.wikipedia.lesson18.explorerscreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson19.ext.invokeAtIndex
import org.wikipedia.lesson19.ext.invokeWithText
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class InTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {

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

    val newsItemRecycler by lazy {
        KRecyclerView(
            parent = matcher,
            builder = { R.id.view_list_card_header },
            itemTypeBuilder = {
                itemType(::InTheNewsArticleItem)
            }
        ).name(withParent("News Item Recycler"))
    }

    fun inTheNewsArticleItemByIndex(index: Int, fnc: InTheNewsArticleItem.() -> Unit) {
        newsItemRecycler.invokeAtIndex(index, fnc)
    }

    fun searchItemByText(text: String, fnc: InTheNewsArticleItem.() -> Unit) {
        newsItemRecycler.invokeWithText(text, fnc)
    }

}