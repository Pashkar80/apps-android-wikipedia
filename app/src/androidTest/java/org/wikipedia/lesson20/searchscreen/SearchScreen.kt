package org.wikipedia.lesson20.searchscreen

import androidx.appcompat.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson22.classwork.widgets.NoSearchWidget
import org.wikipedia.lesson22.classwork.widgets.SearchWidget

object SearchScreen : NamedScreen<SearchScreen>() {
    override val screenName: String = "Search Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchField by lazy {
        KEditText {
            withId(R.id.search_src_text)
        }.name(withParent("Search Field"))
    }

    val title by lazy {
        KTextView {
            withId(org.wikipedia.R.id.history_title)
        }.name(withParent("Title"))
    }

    val searchWidget by lazy {
        SearchWidget {
            withId(org.wikipedia.R.id.search_card)
        }.name(withParent("Search Widget"))
    }

    val noRecentlyWidget by lazy {
        NoSearchWidget {
            withId(org.wikipedia.R.id.history_empty_container)
        }.name(withParent("No Recently Widget"))
    }
}