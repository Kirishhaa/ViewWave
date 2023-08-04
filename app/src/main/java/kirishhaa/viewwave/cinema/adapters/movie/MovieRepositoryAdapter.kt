package kirishhaa.viewwave.cinema.adapters.movie

import kirishhaa.viewwave.core.UnsuccessfulDiscoverMovie
import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kirishhaa.viewwave.main_screen.data.MovieSearchQuery

interface MovieRepositoryAdapter {

    /**
     * @throws UnsuccessfulDiscoverMovie - trouble during discover movies
     */
    suspend fun discoverMovie(movieSearchQuery: MovieSearchQuery): MovieListDataEntity

}