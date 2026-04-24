package org.wikipedia.lesson18.explorerscreen

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.feed.featured.FeaturedArticleCardView
import org.wikipedia.feed.view.FeedView
import org.wikipedia.lesson18.NamedScreen
import org.wikipedia.lesson19.ext.invokeWithText
import org.wikipedia.lesson19.ext.name
import org.wikipedia.lesson21.extentions.invokeAtIndexAndClass
import org.wikipedia.lesson22.classwork.widgets.SearchWidget


object ExploreScreen : NamedScreen<ExploreScreen>() {

    override val screenName: String = "Explore Screen"
    override val layoutId: Int = R.id.feed_view
    override val viewClass: Class<*> = FeedView::class.java

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.name(withParent("Search Widget"))
    }

    val logo = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.name(withParent("Logo"))

    val date = KTextView {
        withId(R.id.day_header_text)
    }.name(withParent("Date"))

    val retryButton = KButton {
        withId(R.id.view_card_offline_button_retry)
    }.name(withParent("Button Retry"))

    val offlineCardText = KTextView {
        withText(R.string.view_offline_card_text)
    }.name(withParent("Offline Card Text"))

    val searchField = KTextView {
        withText("Search Wikipedia")
    }.name(withParent("Search Field"))

    val items = KRecyclerView(
        builder = { withId(R.id.feed_view) },
        itemTypeBuilder = {
            itemType(::SearchItem)
            itemType(::CustomizeItem)
            itemType(::TopReadItem)
            itemType(::InTheNewsItem)
            itemType(::FeaturedArticleItem)
        }
    ).name(withParent("Recycler Items"))

    fun topReadBlock(fnc: TopReadItem.() -> Unit) {
        items.invokeWithText("Top read", fnc)
    }

    fun featuredArticleBlock(index: Int, fnc: FeaturedArticleItem.() -> Unit) {
        items.invokeAtIndexAndClass(
            index,
            (index + 1) * 10,
            1,
            FeaturedArticleCardView::class.java,
            "Featured Article",
            fnc
        )
    }
}