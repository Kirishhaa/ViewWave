package kirishhaa.viewwave.cinema.mainscreen.usecases

import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.domain.MovieItemClickedUseCase
import javax.inject.Inject

class MovieItemClickedAdapter @Inject constructor() : MovieItemClickedUseCase {

    override suspend fun onMovieItemClicked(item: MovieListItem) {
        TODO("Not yet implemented")
    }

}