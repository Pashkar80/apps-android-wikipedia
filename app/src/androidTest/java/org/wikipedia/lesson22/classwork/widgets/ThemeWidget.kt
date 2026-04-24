package org.wikipedia.lesson22.classwork.widgets

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class ThemeWidget(builder: ViewBuilder.() -> Unit) : KWidget<ThemeWidget>(builder) {

    val matchSystemThemeSwitch by lazy {
        KSwitch(matcher) {
            withId(R.id.theme_chooser_match_system_theme_switch)
        }.name(withParent("Match System Theme Switch"))
    }

    val buttonThemeDark by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_dark)
        }.name(withParent("Theme Dark Button"))
    }

    val buttonThemeBlack by lazy {
        KButton(matcher) {
            withId(R.id.button_theme_black)
        }.name(withParent("Theme Black Button"))
    }

}