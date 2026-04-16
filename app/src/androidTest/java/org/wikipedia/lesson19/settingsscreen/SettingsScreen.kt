package org.wikipedia.lesson19.settingsscreen

import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson19.ext.invokeWithText
import org.wikipedia.lesson19.ext.name

object SettingsScreen : NamedScreen<SettingsScreen>() {

    override val screenName: String = "Explore Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val items = KRecyclerView(
        builder = { withId(R.id.recycler_view) },
        itemTypeBuilder = {
            itemType(::ShowLinkPreviewsItem)
        }
    ).name(withParent("Settings Recycler Items"))

    fun showLinkPreviewsBlock(fnc: ShowLinkPreviewsItem.() -> Unit) {
        items.invokeWithText("Show link previews", fnc)
    }

}