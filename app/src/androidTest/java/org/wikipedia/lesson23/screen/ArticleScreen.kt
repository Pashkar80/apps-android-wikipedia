package org.wikipedia.lesson23.screen

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson23.ReferencesItem
import org.wikipedia.lesson23.ext.withXpath
import org.wikipedia.lesson23.ext.withXpathList

object ArticleScreen : NamedScreen<ArticleScreen>() {
    override val screenName: String = "Article Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val title by lazy {
        webView.withXpath("//h1")
            .name(withParent("Title"))
    }

    val references by lazy {
        webView.withXpath("//*[@id='References']")
            .name(withParent("Block References"))
    }

    val referencesList by lazy {
        webView.withXpathList("//ol")
            .name(withParent("References List"))
    }

    fun referenceItem(index: Int, fnc: ReferencesItem.() -> Unit) {
        referencesList.childAt(index, fnc)
    }
}