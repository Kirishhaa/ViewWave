package kirishhaa.viewwave.cinema.mainscreen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.cinema.mainscreen.usecases.LoadMoviesAdapter
import kirishhaa.viewwave.main_screen.domain.LoadMoviesUseCase

@Module
@InstallIn(SingletonComponent::class)
interface LoadMoviesModule {

    @Binds
    fun bindLoadMovies(loadMoviesAdapter: LoadMoviesAdapter): LoadMoviesUseCase
}