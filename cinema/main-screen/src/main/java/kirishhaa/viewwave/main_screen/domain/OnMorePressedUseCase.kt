package kirishhaa.viewwave.main_screen.domain

interface OnMorePressedUseCase {
    suspend fun onMorePressed(genreId: Int)
}