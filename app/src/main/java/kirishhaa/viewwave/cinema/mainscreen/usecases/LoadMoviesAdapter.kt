package kirishhaa.viewwave.cinema.mainscreen.usecases

import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.domain.LoadMoviesUseCase
import javax.inject.Inject

class LoadMoviesAdapter @Inject constructor() : LoadMoviesUseCase {

    override suspend fun loadMovies(page: Int): List<MovieListItem> {
        TODO("Not yet implemented")
    }

}