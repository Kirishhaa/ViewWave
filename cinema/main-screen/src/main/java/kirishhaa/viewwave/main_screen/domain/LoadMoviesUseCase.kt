package kirishhaa.viewwave.main_screen.domain

import kirishhaa.viewwave.main_screen.data.MovieListItem

interface LoadMoviesUseCase {

    suspend fun loadMovies(page: Int): List<MovieListItem>

}