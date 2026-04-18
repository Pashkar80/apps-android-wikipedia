package org.wikipedia.lesson20.searchscreen

import androidx.appcompat.R
import io.github.kakaocup.kakao.edit.KEditText
import org.wikipedia.lesson18.NamedScreen

object SearchScreen : NamedScreen<SearchScreen>() {
    override val screenName: String = "Search Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchField = KEditText {
        withId(R.id.search_src_text)
    }
}