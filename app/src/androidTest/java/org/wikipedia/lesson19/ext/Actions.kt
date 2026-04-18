package org.wikipedia.lesson19.ext

import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.views.KBaseView
import org.wikipedia.lesson20.ext.multiAction

class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Click on '${element.getName()}'", element)
    }

    fun multiAction(element: KBaseView<*>, text: String? = null) {
        element.multiAction(text)
    }
}