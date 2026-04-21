package org.wikipedia.lesson19.settingsscreen

import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson19.ext.invokeWithText
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson21.extentions.invokeAtIndexAndId

object SettingsScreen : NamedScreen<SettingsScreen>() {

    override val screenName: String = "Explore Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val items = KRecyclerView(
        builder = { withId(R.id.recycler_view) },
        itemTypeBuilder = {
            itemType(::ShowLinkPreviewsItem)
            itemType(::DownloadWiFiItem)
            itemType(::CollapseTablesItem)
            itemType(::TermsOfUseItem)
        }
    ).name(withParent("Settings Recycler Items"))

    fun showLinkPreviewsBlock(fnc: ShowLinkPreviewsItem.() -> Unit) {
        items.invokeWithText("Show link previews", fnc)
    }

    fun downloadWiFiBlock(fnc: DownloadWiFiItem.() -> Unit) {
        items.invokeWithText("Download only over Wi-Fi", fnc)
    }

    fun collapseTablesItemBlock(
        index: Int,
        resourceId: Int,
        fnc: CollapseTablesItem.() -> Unit
    ) {
        items.invokeAtIndexAndId(
            index,
            (index + 1) * 10,
            1,
            resourceId,
            "Settings Block By Index And Id -> $index",
            fnc
        )
    }


    fun termsOfUseItemBlock(
        index: Int,
        resourceId: Int,
        fnc: TermsOfUseItem.() -> Unit
    ) {
        items.invokeAtIndexAndId(
            index,
            (index + 1) * 10,
            1,
            resourceId,
            "Settings Block By Index And Id -> $index",
            fnc
        )
    }
}
