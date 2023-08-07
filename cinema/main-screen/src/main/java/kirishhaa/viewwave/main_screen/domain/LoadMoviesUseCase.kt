package kirishhaa.viewwave.main_screen.domain

import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.data.MovieSearchQuery

interface LoadMoviesUseCase {

    suspend fun loadMovies(movieSearchQuery: MovieSearchQuery): List<MovieListItem>

}