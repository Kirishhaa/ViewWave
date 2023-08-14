package kirishhaa.viewwave.cinema.mainscreen.usecases

import kirishhaa.viewwave.main_screen.domain.MovieDetailClickedUseCase
import kirishhaa.viewwave.main_screen.presentation.main.MainFragment
import kirishhaa.viewwave.navigation.domain.BottomNavigator
import kirishhaa.viewwavemovie_details_screen.presentation.MovieDetailFragment
import javax.inject.Inject

class MovieDetailClickedAdapter @Inject constructor(
    private val navigator: BottomNavigator,
) : MovieDetailClickedUseCase {

    override suspend fun onMovieDetailClicked(id: Int) {
        val movieDetailFragment = MovieDetailFragment.newInstance(id)
        navigator.navigateToFragment(
            parentTag = MainFragment.TAG,
            fragmentTag = MovieDetailFragment.TAG,
            toFragment = movieDetailFragment
        )
    }


}