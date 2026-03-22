package org.wikipedia.lesson13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R

class ArticlePopupScreen : KScreen<ArticlePopupScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val readArticleButton = KButton {
        withId(R.id.link_preview_primary_button)
    }
}