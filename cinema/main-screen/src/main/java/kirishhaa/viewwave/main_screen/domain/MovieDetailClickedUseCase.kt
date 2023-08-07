package kirishhaa.viewwave.main_screen.domain

interface MovieDetailClickedUseCase {

    suspend fun onMovieDetailClicked(id: Int)

}