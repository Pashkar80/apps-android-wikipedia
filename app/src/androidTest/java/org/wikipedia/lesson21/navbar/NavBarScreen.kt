package org.wikipedia.lesson21.navbar

import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson19.ext.name

object NavBarScreen : NamedScreen<NavBarScreen>() {
    override val screenName: String = "Nav Bar Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val moreButton = KTextView {
        withText("More")
        isCompletelyDisplayed()
    }.name(withParent("More Button"))

    val settingsButton = KTextView {
        withText("Settings")
        withParent({ withId(R.id.main_drawer_settings_container) })
    }.name(withParent("Settings Button"))

    val searchButton = KTextView {
        withText("Search")
        isCompletelyDisplayed()
    }.name(withParent("Search Button"))

}