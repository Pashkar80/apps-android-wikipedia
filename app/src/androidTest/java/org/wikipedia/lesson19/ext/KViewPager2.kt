package org.wikipedia.lesson19.ext

import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.pager2.KViewPagerItem

inline fun <reified T : KViewPagerItem<T>> KViewPager2.invokeByIndex(
    index: Int, fnc: T.() -> Unit
) {
    val pager = this
    childAt<T>(index) {
        name(pager.withParent("$index"))
        fnc()
    }
}