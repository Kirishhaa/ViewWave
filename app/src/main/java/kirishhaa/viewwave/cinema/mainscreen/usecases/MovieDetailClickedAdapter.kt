package kirishhaa.viewwave.cinema.mainscreen.usecases

import kirishhaa.viewwave.main_screen.domain.MovieDetailClickedUseCase
import kirishhaa.viewwave.navigation.domain.GlobalNavigator
import kirishhaa.viewwavemovie_details_screen.presentation.MovieDetailFragment
import javax.inject.Inject

class MovieDetailClickedAdapter @Inject constructor(
    private val navigator: GlobalNavigator
) : MovieDetailClickedUseCase {

    override suspend fun onMovieDetailClicked(id: Int) {
        val movieDetailFragment = MovieDetailFragment.newInstance(id)
        navigator.navigateToFragment(movieDetailFragment, true)
    }


}