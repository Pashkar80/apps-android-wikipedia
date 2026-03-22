package org.wikipedia.lesson13

import androidx.appcompat.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText

object SearchScreen : KScreen<SearchScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val searchField = KEditText {
        withId(R.id.search_src_text)
    }
}
