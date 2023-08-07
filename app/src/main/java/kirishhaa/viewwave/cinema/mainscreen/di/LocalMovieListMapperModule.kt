package kirishhaa.viewwave.cinema.mainscreen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.cinema.mainscreen.mapper.LocalMovieListMapper
import kirishhaa.viewwave.cinema.mainscreen.mapper.LocalMovieListMapperImpl

@Module
@InstallIn(SingletonComponent::class)
interface LocalMovieListMapperModule {

    @Binds
    fun bindLocalMovieListMapper(localMovieListMapperImpl: LocalMovieListMapperImpl): LocalMovieListMapper
}