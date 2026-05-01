package org.wikipedia.lesson24.ext

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsMatcher
import io.github.kakaocup.compose.node.action.NodeActions
import io.github.kakaocup.compose.node.assertion.NodeAssertions
import io.github.kakaocup.compose.node.builder.ViewBuilder
import io.github.kakaocup.compose.node.core.BaseNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemBuilder
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode
import org.wikipedia.compose.uitest.LazyListItemPositionSemantics
import org.wikipedia.compose.uitest.LazyListSizeSemantics
import org.wikipedia.lesson24.actionforcompose.ClickIfEnabledAction
import org.wikipedia.lesson24.actionforcompose.TrimmedTextAssertions
import org.wikipedia.lesson24.name
import org.wikipedia.lesson24.withParent

fun NodeAssertions.assertTrimmedTextIsEquals(expected: String) {
    delegate.check(TrimmedTextAssertions(expected))
}

fun NodeActions.clickIfEnabled() {
    delegate.perform(ClickIfEnabledAction())
}

fun BaseNode<*>.createLazyList(
    viewBuilderAction: ViewBuilder.() -> Unit,
    itemTypeBuilder: KLazyListItemBuilder.() -> Unit,
) = KLazyListNode(
    viewBuilderAction = viewBuilderAction,
    itemTypeBuilder = itemTypeBuilder,
    positionMatcher = {
        SemanticsMatcher.expectValue(LazyListItemPositionSemantics, it)
    },
    lengthSemanticsPropertyKey = LazyListSizeSemantics,
)

@OptIn(ExperimentalTestApi::class)
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

@OptIn(ExperimentalTestApi::class)
inline fun <reified T : KLazyListItemNode<*>> KLazyListNode.invokeWithText(
    text: String,
    fnc: T.() -> Unit
) {
    childWith<T> {
        hasText(text, true)
    }.name(withParent(text))
        .fnc()
}