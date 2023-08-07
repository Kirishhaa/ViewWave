package kirishhaa.viewwave.cinema.mainscreen.adapters

import kirishhaa.viewwave.cinema.mainscreen.mapper.LocalMovieListMapper
import kirishhaa.viewwave.core.logD
import kirishhaa.viewwave.data.movie.repository.MovieRepository
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwave.main_screen.data.MovieSearchQuery
import javax.inject.Inject

class MovieRepositoryAdapterImpl @Inject constructor(
    private val movieRepository: MovieRepository,
    private val mapper: LocalMovieListMapper
) : MovieRepositoryAdapter {

    override suspend fun discoverMovie(movieSearchQuery: MovieSearchQuery): List<MovieListItem> {
        val localMovieList = movieRepository.discoverMovie(
            includeAdult = movieSearchQuery.includeAdult,
            includeVideo = movieSearchQuery.includeVideo,
            language = movieSearchQuery.language,
            page = movieSearchQuery.page,
            sortBy = movieSearchQuery.sortBy
        )
        return mapper.mapToMovieListItem(localMovieList)
    }

}