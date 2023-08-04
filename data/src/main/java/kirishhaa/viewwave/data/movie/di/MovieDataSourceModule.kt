package kirishhaa.viewwave.data.movie.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.data.movie.datasource.MovieDataSource
import kirishhaa.viewwave.data.movie.datasource.RetrofitDataSource

@Module
@InstallIn(SingletonComponent::class)
interface MovieDataSourceModule {

    @Binds
    fun bindMovieDataSource(retrofitDataSource: RetrofitDataSource): MovieDataSource

}