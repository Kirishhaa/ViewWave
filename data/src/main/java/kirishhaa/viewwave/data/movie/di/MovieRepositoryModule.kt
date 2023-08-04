package kirishhaa.viewwave.data.movie.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.data.movie.repository.DefaultMovieRepository
import kirishhaa.viewwave.data.movie.repository.MovieRepository

@Module
@InstallIn(SingletonComponent::class)
interface MovieRepositoryModule {

    @Binds
    fun bindMovieRepository(movieRepository: DefaultMovieRepository): MovieRepository

}