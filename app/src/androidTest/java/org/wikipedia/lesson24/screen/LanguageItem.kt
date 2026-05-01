package org.wikipedia.lesson24.screen

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.kaspersky.components.composesupport.core.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import org.wikipedia.compose.uitest.Tags.CANONICAL_LANGUAGE_NAME
import org.wikipedia.compose.uitest.Tags.LOCALIZED_LANGUAGE_NAME
import org.wikipedia.lesson24.name
import org.wikipedia.lesson24.withParent

class LanguageItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null
) : KLazyListItemNode<LanguageItem>(semanticNode, semanticsProvider) {

    val localeName by lazy {
        child<KNode> {
            hasTestTag(LOCALIZED_LANGUAGE_NAME)
        }.name(withParent("Locale name"))
    }

    val canonicName by lazy {
        child<KNode> {
            hasTestTag(CANONICAL_LANGUAGE_NAME)
        }.name(withParent("Canonic name"))
    }
}