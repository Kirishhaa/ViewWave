package kirishhaa.viewwave.cinema.mainscreen.usecases

import kirishhaa.viewwave.cinema.mainscreen.adapters.MovieRepositoryAdapter
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.data.MovieSearchQuery
import kirishhaa.viewwave.main_screen.domain.LoadMoviesUseCase
import javax.inject.Inject

class LoadMoviesAdapter @Inject constructor(
    private val movieRepositoryAdapter: MovieRepositoryAdapter
) : LoadMoviesUseCase {

    override suspend fun loadMovies(movieSearchQuery: MovieSearchQuery): List<MovieListItem> {
        return movieRepositoryAdapter.discoverMovie(movieSearchQuery)
    }

}