package kirishhaa.viewwave.cinema.adapters.movie

import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kirishhaa.viewwave.data.movie.repository.MovieRepository
import kirishhaa.viewwave.main_screen.data.MovieSearchQuery
import javax.inject.Inject

class MovieRepositoryAdapterImpl @Inject constructor(
    private val movieRepository: MovieRepository,
) : MovieRepositoryAdapter {

    override suspend fun discoverMovie(movieSearchQuery: MovieSearchQuery): MovieListDataEntity {
        return movieRepository.discoverMovie(
            includeAdult = movieSearchQuery.includeAdult,
            includeVideo = movieSearchQuery.includeVideo,
            language = movieSearchQuery.language,
            page = movieSearchQuery.page,
            sortBy = movieSearchQuery.sortBy
        )
    }
}