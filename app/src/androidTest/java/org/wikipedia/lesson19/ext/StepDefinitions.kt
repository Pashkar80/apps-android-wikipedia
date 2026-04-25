package org.wikipedia.lesson19.ext

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.switch.SwitchableActions
import io.github.kakaocup.kakao.switch.SwitchableActions.Direction.LEFT
import io.github.kakaocup.kakao.switch.SwitchableActions.Direction.RIGHT
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson23.kwebview.KWebViewElement
import org.wikipedia.lesson23.kwebview.KWebViewList

class StepDefinitions(private val testContext: TestContext<*>) {

    fun click(step: String, element: BaseActions) {
        execute(step) {
            element.click()
        }
    }

    fun click(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction { click() }
        }
    }

    fun isDisplayed(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisplayed()
        }
    }

    fun isDisplayed(step: String, element: KWebViewElement) {
        execute(step) {
            element.performWebViewAction { scroll() }
        }
    }

    fun isDisplayed(step: String, element: KWebViewList) {
        execute(step) {
            element.performWebViewAction { scroll() }
        }
    }

    fun isNotChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isNotChecked()
        }
    }

    fun isChecked(step: String, element: CheckableAssertions) {
        execute(step) {
            element.isChecked()
        }
    }

    fun isEnabled(step: String, element: BaseAssertions) {
        execute(step) {
            element.isEnabled()
        }
    }

    fun isDisabled(step: String, element: BaseAssertions) {
        execute(step) {
            element.isDisabled()
        }
    }

    fun hasText(step: String, element: TextViewAssertions, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.containsText(text)
            } else {
                element.hasText(text)
            }
        }
    }

    fun hasText(step: String, element: KWebViewElement, text: String, isSubstring: Boolean) {
        execute(step) {
            if (isSubstring) {
                element.performWebViewAction { containsText(text) }
            } else {
                element.performWebViewAction { hasText(text) }
            }
        }
    }

    fun doesNotExist(step: String, element: BaseAssertions) {
        execute(step) {
            element.doesNotExist()
        }
    }

    fun swipeSwitchLeft(step: String, element: SwitchableActions) {
        execute(step) {
            element.swipeSwitchThumb(LEFT)
        }

    }

    fun swipeSwitchRight(step: String, element: SwitchableActions) {
        execute(step) {
            element.swipeSwitchThumb(RIGHT)
        }
    }

    private fun execute(step: String, fnc: () -> Unit) {
        testContext.step(step) {
            fnc()
        }
    }
}