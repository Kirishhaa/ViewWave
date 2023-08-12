package kirishhaa.viewwave.cinema.mainscreen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.cinema.adapters.MovieRepositoryAdapter
import kirishhaa.viewwave.cinema.adapters.MovieRepositoryAdapterImpl

@Module
@InstallIn(SingletonComponent::class)
interface MovieRepositoryAdapterModule {

    @Binds
    fun bindMovieRepositoryAdapter(movieRepositoryAdapterImpl: MovieRepositoryAdapterImpl): MovieRepositoryAdapter

}