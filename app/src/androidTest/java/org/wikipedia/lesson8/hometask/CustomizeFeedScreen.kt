package org.wikipedia.lesson8.hometask

import androidx.appcompat.widget.AppCompatImageButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

object CustomizeFeedScreen : KScreen<CustomizeFeedScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val backButton = KImageView {
        withParent {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }


    val item = KRecyclerView(
        builder = { withId(R.id.content_types_recycler) },
        itemTypeBuilder = {
            itemType(::CustomizeFeedItem)
        }
    )
}

