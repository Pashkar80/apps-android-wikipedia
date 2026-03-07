package org.wikipedia.lesson8.hometask

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.view.FeedView

object ExplorerScreen : KScreen<ExplorerScreen>() {
    override val layoutId: Int = R.id.feed_view
    override val viewClass: Class<*> = FeedView::class.java

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val date = KTextView {
        withId(R.id.day_header_text)
    }


    val item = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::SearchItem)
            itemType(::CustomizeItem)
            itemType(::TopReadItem)
            itemType(::InTheNewsItem)
            itemType(::FuturedArticleItem)
        }
    )


}