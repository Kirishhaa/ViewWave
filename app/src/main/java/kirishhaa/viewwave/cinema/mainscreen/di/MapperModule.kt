package kirishhaa.viewwave.cinema.mainscreen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.cinema.mainscreen.mapper.MovieDataEntityMapper
import kirishhaa.viewwave.cinema.mainscreen.mapper.MovieDataEntityMapperImpl
import kirishhaa.viewwave.cinema.mainscreen.mapper.MovieListDataEntityMapper
import kirishhaa.viewwave.cinema.mainscreen.mapper.MovieListDataEntityMapperImpl

@Module
@InstallIn(SingletonComponent::class)
interface MapperModule {

    @Binds
    fun bindMovieListDEMapper(localMovieListMapperImpl: MovieListDataEntityMapperImpl): MovieListDataEntityMapper


    @Binds
    fun bindMovieDEMapper(movieDataEntityMapperImpl: MovieDataEntityMapperImpl): MovieDataEntityMapper

}