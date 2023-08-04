package kirishhaa.viewwave.main_screen.presentation.recyclerview.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import kirishhaa.viewwave.core.recyclerview.SingleListAdapter
import kirishhaa.viewwave.main_screen.R
import kirishhaa.viewwave.main_screen.data.MovieListItem

class MovieAdapter: SingleListAdapter<MovieListItem, MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_recycle_item, parent, false)
        return MovieViewHolder(view)
    }

}