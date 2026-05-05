package org.wikipedia.lesson19.ext

import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson20.ext.equalsWithTrim
import org.wikipedia.lesson23.kwebview.KWebViewElement
import org.wikipedia.lesson23.kwebview.KWebViewList
import org.wikipedia.lesson24.getName

class Verify(private val steps: StepDefinitions) : StepsDsl<Verify>() {

    override val self = this

    fun isDisplayed(element: BaseAssertions) {
        steps.isDisplayed(
            "Verify text displayed '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun isDisplayed(element: KWebViewElement) {
        steps.isDisplayed(
            "Verify element displayed '${element.getName()}'",
            element
        )
    }

    fun isDisplayed(element: KWebViewList) {
        steps.isDisplayed(
            "Verify list displayed '${element.getName()}'",
            element
        )
    }

    fun isNotChecked(element: CheckableAssertions) {
        steps.isNotChecked(
            "Verify toggle is not checked '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun isChecked(element: CheckableAssertions) {
        steps.isChecked(
            "Verify toggle is checked '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun isEnabled(element: BaseAssertions) {
        steps.isEnabled(
            "Verify element is enabled '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun isDisabled(element: BaseAssertions) {
        steps.isDisabled(
            "Verify element is disables '${(element as BaseActions).getName()}'",
            element
        )
    }

    fun hasText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Verify that text in element '${(element as BaseActions).getName()}' equals '$text'",
            element,
            text,
            false
        )
    }

    fun hasText(element: KWebViewElement, text: String) {
        steps.hasText(
            "Verify that text in element '${element.getName()}' equals '$text'",
            element,
            text,
            false
        )
    }

    fun containsText(element: TextViewAssertions, text: String) {
        steps.hasText(
            "Verify that text in element '${(element as BaseActions).getName()}' contains substring '$text'",
            element,
            text,
            true
        )
    }

    fun doesNotExist(element: BaseAssertions) {
        steps.doesNotExist(
            "Проверяет, что элемент '${(element as BaseActions).getName()}' отсутствует",
            element
        )
    }

    fun equalsWithTrim(text: String, element: TextViewAssertions) {
        element.equalsWithTrim(text)
    }

    fun assertTrimmedTextIsEquals(element: NodeAssertions, expected: String) {
        steps.assertTrimmedTextIsEquals(
            "Verify trimmed text is equals '${(element as NodeActions).getName()}'",
            element,
            expected
        )
    }
}