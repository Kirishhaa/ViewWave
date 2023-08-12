package kirishhaa.viewwave.data.movie.repository

import kirishhaa.viewwave.core.UnsuccessfulDiscoverMovie
import kirishhaa.viewwave.core.UnsuccessfulGetDetailMovie
import kirishhaa.viewwave.core.logD
import kirishhaa.viewwave.data.entity.movie.MovieDataEntity
import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kirishhaa.viewwave.data.movie.datasource.MovieDataSource
import javax.inject.Inject

class DefaultMovieRepository @Inject constructor(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun discoverMovie(
        includeAdult: Boolean?,
        includeVideo: Boolean?,
        language: String?,
        page: Int?,
        sortBy: String?,
        genreId: Int?
    ): MovieListDataEntity {
        val movieList = movieDataSource
            .discoverMovie(includeAdult, includeVideo, language, page, sortBy, genreId)
        return movieList
    }

    override suspend fun getDetailMovie(id: Int): MovieDataEntity {
        val detailedMovie = movieDataSource.getMovieDetailById(id)
        return detailedMovie
    }


}