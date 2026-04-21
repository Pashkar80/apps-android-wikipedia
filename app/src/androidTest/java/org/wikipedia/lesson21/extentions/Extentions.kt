package org.wikipedia.lesson21.extentions

import android.view.View
import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.lesson19.ext.getName
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson21.HasClassOrChildWithClass
import org.wikipedia.lesson21.HasIdOrChildWithIdAction
import kotlin.math.min

fun BaseActions.hasIdOrChildWithId(resourceId: Int): Boolean {
    val hasIdOrChildWithIdIdAction = HasIdOrChildWithIdAction(resourceId)
    view.perform(hasIdOrChildWithIdIdAction)
    return hasIdOrChildWithIdIdAction.getResult()
}

fun BaseActions.hasClassOrChildWithClass(clazz: Class<out View>): Boolean {
    val hasClassOrChildWithClass = HasClassOrChildWithClass(clazz)
    view.perform(hasClassOrChildWithClass)
    return hasClassOrChildWithClass.getResult()
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndClass(
    index: Int,
    limit: Int,
    startWith: Int,
    clazz: Class<out View>,
    blockName: String = "$index",
    fnc: T.() -> Unit
) {
    val countOfItems = getSize()
    val lastIndex = min(countOfItems - 1, limit)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    val recyclerName = getName()
    var isElementFoundByIndex = false
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementWithClass = hasClassOrChildWithClass(clazz)
            if (isElementWithClass && counter++ == index) {
                isElementFoundByIndex = true
                name(recyclerName.withParent(blockName))
                fnc()
            }
        }
        if (isElementFoundByIndex) break
    }
    if (!isElementFoundByIndex) {
        error("Element with $index in limit ${countOfItems + 1} elements not found")
    }
}

inline fun <reified T : KRecyclerItem<T>> KRecyclerView.invokeAtIndexAndId(
    index: Int,
    limit: Int,
    startWith: Int,
    resourceId: Int,
    blockName: String = "$index",
    fnc: T.() -> Unit
) {
    val countOfItems = getSize()
    val lastIndex = min(countOfItems - 1, limit)
    val firstIndex = min(startWith, lastIndex)
    var counter = 0
    var isElementFoundByIndex = false
    val recyclerName = getName()
    for (i in firstIndex..lastIndex) {
        childAt<T>(i) {
            val isElementWithResourceId = hasIdOrChildWithId(resourceId)
            if (isElementWithResourceId && counter++ == index) {
                isElementFoundByIndex = true
                name(recyclerName.withParent(blockName))
                fnc()
            }
        }
        if (isElementFoundByIndex) break
    }
    if (!isElementFoundByIndex) {
        error("Element with $index in limit ${countOfItems + 1} elements not found")
    }
}
