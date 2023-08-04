package kirishhaa.viewwave.main_screen.domain

import kirishhaa.viewwave.main_screen.data.MovieListItem

interface MovieItemClickedUseCase {

    suspend fun onMovieItemClicked(item: MovieListItem)

}