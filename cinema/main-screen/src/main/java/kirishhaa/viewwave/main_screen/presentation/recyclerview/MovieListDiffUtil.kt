package kirishhaa.viewwave.main_screen.presentation.recyclerview

import kirishhaa.viewwave.core.recyclerview.BaseDiffUtil
import kirishhaa.viewwave.main_screen.data.MovieListItem

class MovieListDiffUtil(
    oldList: List<MovieListItem>,
    newList: List<MovieListItem>,
) : BaseDiffUtil<MovieListItem>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.imagePath == newItem.imagePath
    }

}