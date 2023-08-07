package kirishhaa.viewwave.main_screen.presentation.recyclerview.movie

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kirishhaa.viewwave.core.recyclerview.SingleListViewHolder
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.data.MovieListItem

class MovieViewHolder(
    private val appContext: Context,
    private val listener: MovieAdapter.Listener,
    view: View) :
    SingleListViewHolder<MovieListItem>(view) {
    private val itemImage = view.findViewById<ImageView>(R.id.movie_recycle_item_image)
    private val itemTitle = view.findViewById<TextView>(R.id.movie_recycle_item_title)
    private val itemRate = view.findViewById<TextView>(R.id.movie_recycle_item_rate)

    override fun bindItem(item: MovieListItem) {
        itemView.setOnClickListener {
            listener.onMovieListItemClicked(item)
        }
        Glide.with(appContext)
            .load(item.imagePath)
            .error(R.drawable.ic_error)
            .into(itemImage)
        itemTitle.text = item.title
        itemRate.text = item.rate
    }

}