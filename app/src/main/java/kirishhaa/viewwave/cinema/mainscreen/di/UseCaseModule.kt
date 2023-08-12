package kirishhaa.viewwave.cinema.mainscreen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.cinema.mainscreen.usecases.LoadMoviesAdapter
import kirishhaa.viewwave.cinema.mainscreen.usecases.MovieDetailClickedAdapter
import kirishhaa.viewwave.cinema.mainscreen.usecases.OnMorePressedAdapter
import kirishhaa.viewwave.main_screen.domain.LoadMoviesUseCase
import kirishhaa.viewwave.main_screen.domain.MovieDetailClickedUseCase
import kirishhaa.viewwave.main_screen.domain.OnMorePressedUseCase

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindLoadMovies(loadMoviesAdapter: LoadMoviesAdapter): LoadMoviesUseCase

    @Binds
    fun bindMovieItemClicked(movieItemClickedAdapter: MovieDetailClickedAdapter): MovieDetailClickedUseCase

    @Binds
    fun bindOnMorePressed(onMorePressedAdapter: OnMorePressedAdapter): OnMorePressedUseCase
}