package kirishhaa.viewwave.data.movie.repository

import kirishhaa.viewwave.core.UnsuccessfulDiscoverMovie
import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity

interface MovieRepository {

    /**
     * @throws UnsuccessfulDiscoverMovie - trouble during discover movies
     */
    suspend fun discoverMovie(
        includeAdult: Boolean?,
        includeVideo: Boolean?,
        language: String?,
        page: Int,
        sortBy: String?
    ): MovieListDataEntity

}