package org.wikipedia.lesson20

import android.view.View
import android.widget.Button
import android.widget.Checkable
import android.widget.EditText
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class MultiAction(private val enableText: String?) : ViewAction {

    override fun getConstraints(): Matcher<View?>? {
        return ViewMatchers.isDisplayed()
    }

    override fun getDescription(): String {
        return "Toggle on toggleable or type 'On' in text input"
    }

    override fun perform(
        uiController: UiController?,
        view: View?
    ) {
        if (view == null) return
        when (view) {
            is Button -> view.performClick()
            is Checkable -> view.isChecked = true
            is EditText -> ViewActions.typeText(enableText).perform(uiController, view)
            else -> error("Element -> $view is not implemented")
        }
    }
}
/*
Очень важна последовательность в методе perform потому
как button - checkable и метод некорректно работать
с checkbox не добился толку потому что view - MaterialSwitch
а KCheckBox - нет
 */