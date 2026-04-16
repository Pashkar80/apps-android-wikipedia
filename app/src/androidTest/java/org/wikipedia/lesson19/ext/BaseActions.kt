package org.wikipedia.lesson19.ext

import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.lesson18.NameHierarchy

private val elements = mutableMapOf<BaseActions, NameHierarchy>()

fun <T : BaseActions> T.name(nameHierarchy: NameHierarchy): T {
    elements[this] = nameHierarchy
    return this
}

fun <T : BaseActions> T.getName(): NameHierarchy {
    return elements[this] ?: NameHierarchy("NO_LABEL", null)
}

fun <T : BaseActions> T.withParent(name: String): NameHierarchy {
    return getName().withParent(name)
}