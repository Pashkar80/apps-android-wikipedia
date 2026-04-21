package org.wikipedia.lesson19.settingsscreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.switch.KSwitch
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class CollapseTablesItem(matcher: Matcher<View>) :
    KRecyclerItem<CollapseTablesItem>(matcher) {

    val collapseTablesToggle by lazy {
        KSwitch(matcher) {
            withId(R.id.switchWidget)
        }.name(withParent("Collapse Tables Toggle"))
    }
}