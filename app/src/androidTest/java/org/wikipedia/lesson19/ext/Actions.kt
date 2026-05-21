package org.wikipedia.lesson19.ext

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.views.KBaseView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.switch.SwitchableActions
import org.wikipedia.lesson20.ext.multiAction
import org.wikipedia.lesson23.kwebview.KWebViewElement
import org.wikipedia.lesson24.getName


class Actions(private val steps: StepDefinitions) : StepsDsl<Actions>() {

    override val self = this

    fun click(element: BaseActions) {
        steps.click("Click on '${element.getName()}'", element)
    }

    fun click(element: KWebViewElement) {
        steps.click("Click on '${element.getName()}'", element)
    }

    fun typeText(element: KEditText, text: String) {
        steps.typeText("Type text on '${element.getName()}'", element, text)
    }

    fun multiAction(element: KBaseView<*>, text: String? = null) {
        element.multiAction(text)
    }

    fun swipeSwitchLeft(element: SwitchableActions) {
        steps.swipeSwitchLeft("Swipe switch left on '${element.getName()}'", element)
    }

    fun swipeSwitchRight(element: SwitchableActions) {
        steps.swipeSwitchRight("Swipe switch right on '${element.getName()}'", element)
    }

    fun clickIfEnabled(element: NodeActions) {
        steps.clickIfEnabled("Click if enabled '${element.getName()}'", element)
    }
}