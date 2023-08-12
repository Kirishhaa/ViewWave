package kirishhaa.viewwave.cinema.adapters

import kirishhaa.viewwave.core.UnsuccessfulDiscoverMovie
import kirishhaa.viewwave.core.UnsuccessfulGetDetailMovie
import kirishhaa.viewwave.main_screen.data.MovieListItem
import kirishhaa.viewwavemovie_details_screen.data.MovieDetail

interface MovieRepositoryAdapter {

    /**
     * @throws UnsuccessfulDiscoverMovie - trouble during discover movies
     */
    suspend fun discoverMovie(genreId: Int, page: Int): List<MovieListItem>

    /**
     * @throws UnsuccessfulGetDetailMovie
     */
    suspend fun getMovieDetailById(id: Int): MovieDetail

}