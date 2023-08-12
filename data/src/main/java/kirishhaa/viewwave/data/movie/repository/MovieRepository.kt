package kirishhaa.viewwave.data.movie.repository

import kirishhaa.viewwave.core.UnsuccessfulDiscoverMovie
import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kirishhaa.viewwave.core.UnsuccessfulGetDetailMovie
import kirishhaa.viewwave.data.entity.movie.MovieDataEntity

interface MovieRepository {

    /**
     * @throws UnsuccessfulDiscoverMovie - trouble during discover movies
     */
    suspend fun discoverMovie(
        includeAdult: Boolean?=null,
        includeVideo: Boolean?=null,
        language: String?=null,
        page: Int?=null,
        sortBy: String?=null,
        genreId: Int? = null
    ): MovieListDataEntity

    /**
     * @throws UnsuccessfulGetDetailMovie - operation was unsuccessful
     */
    suspend fun getDetailMovie(id: Int): MovieDataEntity

}