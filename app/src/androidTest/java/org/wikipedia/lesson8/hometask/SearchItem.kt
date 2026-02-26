package org.wikipedia.lesson8.hometask

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {
    val icon = KImageView(matcher) {
        isInstanceOf(AppCompatImageView::class.java)
        isDisplayed()
    }
}