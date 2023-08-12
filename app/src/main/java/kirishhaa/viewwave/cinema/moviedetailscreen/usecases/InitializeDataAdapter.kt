package kirishhaa.viewwave.cinema.moviedetailscreen.usecases

import kirishhaa.viewwave.cinema.adapters.MovieRepositoryAdapter
import kirishhaa.viewwavemovie_details_screen.data.MovieDetail
import kirishhaa.viewwavemovie_details_screen.domain.InitializeDataUseCase
import javax.inject.Inject

class InitializeDataAdapter @Inject constructor(
    private val movieRepositoryAdapter: MovieRepositoryAdapter,
) : InitializeDataUseCase {

    override suspend fun initializeData(id: Int): MovieDetail {
        return movieRepositoryAdapter.getMovieDetailById(id)
    }
}