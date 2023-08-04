package kirishhaa.viewwave.main_screen.presentation.recyclerview.movie

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kirishhaa.viewwave.core.recyclerview.SingleListViewHolder
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.data.MovieListItem

class MovieViewHolder(view: View): SingleListViewHolder<MovieListItem>(view) {
    private val itemImage = view.findViewById<ImageView>(R.id.movie_recycle_item_image)
    private val itemTitle = view.findViewById<TextView>(R.id.movie_recycle_item_title)
    private val itemRate = view.findViewById<TextView>(R.id.movie_recycle_item_rate)

    override fun bindItem(item: MovieListItem) {
        itemImage.setImageDrawable(item.image)
        itemTitle.text = item.title
        itemRate.text = item.rate.toString()
    }

}