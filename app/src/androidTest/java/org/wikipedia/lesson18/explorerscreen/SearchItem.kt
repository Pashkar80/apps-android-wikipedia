package org.wikipedia.lesson18.explorerscreen

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson19.ext.withParent

class SearchItem(matcher: Matcher<View>) : KRecyclerItem<SearchItem>(matcher) {

    val icon by lazy {
        KImageView(matcher) {
            withIndex(0) {
                isInstanceOf(AppCompatImageView::class.java)
            }
        }.name(withParent("Search Icon"))
    }
}