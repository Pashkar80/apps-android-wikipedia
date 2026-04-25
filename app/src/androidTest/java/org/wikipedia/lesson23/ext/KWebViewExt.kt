package org.wikipedia.lesson23.ext

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.lesson23.kwebview.KWebViewElement
import org.wikipedia.lesson23.kwebview.KWebViewList

fun KWebView.withXpath(xpath: String): KWebViewElement {
    return KWebViewElement(
        webView = this, xpath
    )
}

fun KWebView.withXpathList(xpath: String): KWebViewList {
    return KWebViewList(
        webView = this, xpath
    )
}