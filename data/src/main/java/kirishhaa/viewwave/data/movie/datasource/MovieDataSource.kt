package kirishhaa.viewwave.data.movie.datasource

import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kirishhaa.viewwave.core.UnsuccessfulDiscoverMovie

interface MovieDataSource {

    /**
     * @throws UnsuccessfulDiscoverMovie - trouble during discover movies
     */
    suspend fun discoverMovie(
        includeAdult: Boolean?,
        includeVideo: Boolean?,
        language: String?,
        page: Int?,
        sortBy: String?
    ): MovieListDataEntity

}