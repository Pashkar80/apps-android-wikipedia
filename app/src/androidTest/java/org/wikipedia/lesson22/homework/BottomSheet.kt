package org.wikipedia.lesson22.homework


import com.google.android.material.R
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson22.classwork.widgets.SerifSettingsWidget
import org.wikipedia.lesson22.classwork.widgets.ThemeWidget

object BottomSheet : NamedScreen<BottomSheet>() {
    override val screenName: String = "Bottom Sheet"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val serifSettingWidget by lazy {
        SerifSettingsWidget {
            withId(R.id.design_bottom_sheet)
        }.name(withParent("Serif Settings Widget"))
    }

    val themeWidget by lazy {
        ThemeWidget {
            withId(R.id.design_bottom_sheet)
        }.name(withParent("Theme Widget"))
    }

}