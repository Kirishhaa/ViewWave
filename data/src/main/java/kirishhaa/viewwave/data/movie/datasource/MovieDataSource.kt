package kirishhaa.viewwave.data.movie.datasource

import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kirishhaa.viewwave.core.UnsuccessfulDiscoverMovie
import kirishhaa.viewwave.data.entity.movie.MovieDataEntity
import kirishhaa.viewwave.core.UnsuccessfulGetDetailMovie

interface MovieDataSource {

    /**
     * @throws UnsuccessfulDiscoverMovie - trouble during discover movies
     */
    suspend fun discoverMovie(
        includeAdult: Boolean?,
        includeVideo: Boolean?,
        language: String?,
        page: Int?,
        sortBy: String?,
        genreId: Int?
    ): MovieListDataEntity

    /**
     * @throws UnsuccessfulGetDetailMovie
     */
    suspend fun getMovieDetailById(id: Int): MovieDataEntity


}