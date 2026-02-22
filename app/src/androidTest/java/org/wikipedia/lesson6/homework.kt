package org.wikipedia.lesson6

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

val sansSerifButton = KButton {
    withParent {
        withId(R.id.fontFamilyContainer)
    }
    withText("sans-serif")
}

val serifButton = KButton {
    withId(R.id.button_font_family_serif)
}

val lightThemeButton = KButton {
    withId(R.id.button_theme_light)
}

val sepiaThemeButton = KButton {
    withId(R.id.button_theme_sepia)
}

val darkThemeButton = KButton {
    withId(R.id.button_theme_dark)
}

val blackThemeButton = KButton {
    withId(R.id.button_theme_black)
}
val settingsCategoryText = KTextView {
    withId(R.id.textSettingsCategory)
}
val textSizeSeekBar = KSeekBar{
    withId(R.id.text_size_seek_bar)
}

val textSizePercentView= KTextView{
    containsText("%")
}

val decreaseTextSizeView= KTextView{
    withId(R.id.buttonDecreaseTextSize)
}

val increaseTextSizeView= KTextView{
    withId(R.id.buttonIncreaseTextSize)
}

val themeReadingFocusSwitch = KCheckBox {
    withId(R.id.theme_chooser_reading_focus_mode_switch)
}
val themeChooserReadingFocusModeView = KTextView{
    withId(R.id.theme_chooser_reading_focus_mode_description)
}
val matchSystemThemeSwitch = KCheckBox {
    withId(R.id.theme_chooser_match_system_theme_switch)
        }
val darkModeDimImagesSwitch = KCheckBox {
    withId(R.id.theme_chooser_dark_mode_dim_images_switch)
}

val titleView = KTextView{
    withText(R.string.color_theme_select)
}

val image = KImageView{
    isInstanceOf(AppCompatImageView::class.java)
}


