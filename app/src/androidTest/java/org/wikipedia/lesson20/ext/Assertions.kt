package org.wikipedia.lesson20.ext

import io.github.kakaocup.kakao.text.TextViewAssertions
import org.wikipedia.lesson20.EqualsWithTrimAssertion

fun TextViewAssertions.equalsWithTrim(expected: String) {
    view.check(EqualsWithTrimAssertion(expected))
}