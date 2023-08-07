package kirishhaa.viewwave.cinema.mainscreen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.cinema.mainscreen.usecases.MovieDetailClickedAdapter
import kirishhaa.viewwave.main_screen.domain.MovieDetailClickedUseCase

@Module
@InstallIn(SingletonComponent::class)
interface MovieItemClickedModule {

    @Binds
    fun bindMovieItemClicked(movieItemClickedAdapter: MovieDetailClickedAdapter): MovieDetailClickedUseCase
}