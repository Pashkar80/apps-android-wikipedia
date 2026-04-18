package org.wikipedia.lesson20.ext

import io.github.kakaocup.kakao.common.views.KBaseView
import org.wikipedia.lesson20.MultiAction

fun KBaseView<*>.multiAction(text: String? = null) {
    view.perform(MultiAction(text))
}