package org.wikipedia.lesson13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ReferencePopupScreen : KScreen<ReferencePopupScreen>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val title = KTextView {
        withId(R.id.reference_title_text)
    }

    val referenceId = KTextView {
        withId(R.id.reference_id)
    }
}