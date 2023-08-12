package kirishhaa.viewwave.cinema.adapters

import kirishhaa.viewwave.cinema.mainscreen.mapper.MovieDataEntityMapper
import kirishhaa.viewwave.cinema.mainscreen.mapper.MovieListDataEntityMapper
import kirishhaa.viewwave.data.movie.repository.MovieRepository
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwavemovie_details_screen.data.MovieDetail
import javax.inject.Inject

class MovieRepositoryAdapterImpl @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieListDEMapper: MovieListDataEntityMapper,
    private val movieDEMapper: MovieDataEntityMapper,
) : MovieRepositoryAdapter {

    override suspend fun discoverMovie(genreId: Int, page: Int): List<MovieListItem> {
        val localMovieList = movieRepository.discoverMovie(genreId = genreId, page = page)
        return movieListDEMapper.mapToMovieListItem(localMovieList)
    }

    override suspend fun getMovieDetailById(id: Int): MovieDetail {
        val movieDataEntity = movieRepository.getDetailMovie(id)
        return movieDEMapper.mapToMovieDetail(movieDataEntity)
    }

}