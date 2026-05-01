@file:OptIn(ExperimentalTestApi::class)

package org.wikipedia.lesson24

import androidx.compose.ui.test.ExperimentalTestApi
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode
import org.wikipedia.lesson18.NameHierarchy


private val elements = mutableMapOf<NodeActions, NameHierarchy>()

fun <T : NodeActions> T.name(nameHierarchy: NameHierarchy): T {
    elements[this] = nameHierarchy
    return this
}

fun <T : NodeActions> T.getName(): NameHierarchy {
    return elements[this] ?: NameHierarchy("NO_LABEL", null)
}

fun <T : NodeActions> T.withParent(name: String): NameHierarchy {
    return getName().withParent(name)
}

inline fun <reified T : KLazyListItemNode<*>> KLazyListNode.invokeAtIndex(
    index: Int,
    fnc: T.() -> Unit
) {
    val list = this
    childAt<T>(index) {
        name(list.withParent("$index"))
        fnc()
    }
}
