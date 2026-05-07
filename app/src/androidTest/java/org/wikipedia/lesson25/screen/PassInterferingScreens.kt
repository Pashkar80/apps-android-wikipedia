package org.wikipedia.lesson25.screen

import org.wikipedia.lesson25.screenbehavior.ScreenBehaviorBase

class PassInterferingScreens(private val screenBehaviors: List<ScreenBehaviorBase>) {

    /**
     * Вернёт true если мешающий экран был обнаружен и обработан
     */
    fun execute(): Boolean {
        return screenBehaviors.any { it.initBehavior() }
    }
}