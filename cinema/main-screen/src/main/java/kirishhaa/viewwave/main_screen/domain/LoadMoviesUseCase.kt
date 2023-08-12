package kirishhaa.viewwave.main_screen.domain

import kirishhaa.viewwave.main_screen.data.MovieListItem

interface LoadMoviesUseCase {

    suspend fun loadMovies(genreId: Int, page: Int): List<MovieListItem>

}