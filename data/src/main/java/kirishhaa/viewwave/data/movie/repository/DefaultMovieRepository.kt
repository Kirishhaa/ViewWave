package kirishhaa.viewwave.data.movie.repository

import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kirishhaa.viewwave.data.movie.datasource.MovieDataSource
import javax.inject.Inject
import javax.inject.Singleton

class DefaultMovieRepository @Inject constructor(
    private val movieDataSource: MovieDataSource,
) : MovieRepository {

    override suspend fun discoverMovie(
        includeAdult: Boolean?,
        includeVideo: Boolean?,
        language: String?,
        page: Int?,
        sortBy: String?,
    ): MovieListDataEntity {
        return movieDataSource
            .discoverMovie(includeAdult, includeVideo, language, page, sortBy)
    }

    override suspend fun getDetailMovie(id: Int) {
        //TODO
    }


}