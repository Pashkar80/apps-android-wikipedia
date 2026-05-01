package org.wikipedia.lesson24.screen

import org.wikipedia.compose.uitest.Tags.LANGUAGE_LIST
import org.wikipedia.lesson24.ext.createLazyList
import org.wikipedia.lesson24.ext.invokeWithText

class AddLanguageScreen : ComposeNamedScreen<AddLanguageScreen>() {
    override val screenName: String = "Add Language Screen"


    val items by lazy {
        createLazyList(
            viewBuilderAction = {
                hasTestTag(LANGUAGE_LIST)
            },
            itemTypeBuilder = {
                itemType(::LanguageItem)
            }
        )
    }

    fun getFrenchItem(fnc: LanguageItem.() -> Unit) {
        items.invokeWithText("French", fnc)
    }
}