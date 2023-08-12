package kirishhaa.viewwave.cinema.mainscreen.usecases

import kirishhaa.viewwave.main_screen.domain.OnMorePressedUseCase
import kirishhaa.viewwave.main_screen.presentation.allmovie.AllMovieFragment
import kirishhaa.viewwave.navigation.domain.GlobalNavigator
import javax.inject.Inject

class OnMorePressedAdapter @Inject constructor(
    private val globalNavigator: GlobalNavigator,
) : OnMorePressedUseCase {

    override suspend fun onMorePressed(genreId: Int) {
        globalNavigator.navigateToFragment(AllMovieFragment.newInstance(genreId), true)
    }


}