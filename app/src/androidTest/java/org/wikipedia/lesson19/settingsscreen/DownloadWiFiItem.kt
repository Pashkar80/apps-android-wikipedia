package org.wikipedia.lesson19.settingsscreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.switch.KSwitch
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class DownloadWiFiItem(matcher: Matcher<View>) : KRecyclerItem<DownloadWiFiItem>(matcher) {

    val wifiToggle by lazy {
        KSwitch(matcher) {
            withId(R.id.switchWidget)
        }.name(withParent("WiFi Toggle"))
    }
}
// KCheckBox