package org.wikipedia.lesson23

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.lesson23.kwebview.KWebViewItem

class ReferencesItem(
    kWebView: KWebView,
    listContainerXpath: String
) : KWebViewItem(kWebView, listContainerXpath) {
    override val self = this

    val index by lazy {
        child("//a[@class='pcs-ref-back-link']")
            .name(withParent("Index"))
    }

    val text by lazy {
        child("//div[@class='pcs-ref-body']")
            .name(withParent("Text"))
    }

}
