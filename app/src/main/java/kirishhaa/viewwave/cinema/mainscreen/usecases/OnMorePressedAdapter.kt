package kirishhaa.viewwave.cinema.mainscreen.usecases

import kirishhaa.viewwave.main_screen.domain.OnMorePressedUseCase
import kirishhaa.viewwave.main_screen.presentation.allmovie.AllMovieFragment
import kirishhaa.viewwave.main_screen.presentation.main.MainFragment
import kirishhaa.viewwave.navigation.domain.BottomNavigator
import javax.inject.Inject

class OnMorePressedAdapter @Inject constructor(
    private val baseNavigator: BottomNavigator,
) : OnMorePressedUseCase {

    override suspend fun onMorePressed(genreId: Int) {
        baseNavigator.navigateToFragment(
            parentTag = MainFragment.TAG,
            fragmentTag = AllMovieFragment.TAG,
            toFragment = AllMovieFragment.newInstance(genreId)
        )
    }


}