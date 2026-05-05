package org.wikipedia.lesson24.screen

import androidx.appcompat.widget.AppCompatImageButton
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson19.ext.name

object WikipediaLanguageScreen : NamedScreen<WikipediaLanguageScreen>() {
    override val screenName: String = "Wikipedia Language Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val addLanguageButton by lazy {
        KTextView {
            withText("Add language")
        }.name(withParent("Button Add Language"))
    }

    val backButton by lazy {
        KButton {
            withParent { withId(R.id.toolbar) }
            isInstanceOf(AppCompatImageButton::class.java)
        }.name(withParent("Back Button Tool Bar"))
    }
}