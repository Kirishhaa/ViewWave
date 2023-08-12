package kirishhaa.viewwavemovie_details_screen.domain

import kirishhaa.viewwavemovie_details_screen.data.MovieDetail

interface InitializeDataUseCase {

    suspend fun initializeData(id: Int): MovieDetail

}