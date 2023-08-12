package kirishhaa.viewwave.cinema.moviedetailscreen.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.cinema.moviedetailscreen.usecases.InitializeDataAdapter
import kirishhaa.viewwavemovie_details_screen.domain.InitializeDataUseCase

@Module
@InstallIn(SingletonComponent::class)
interface InitializeDataUseCaseModule {

    @Binds
    fun bindInitializeData(initializeDataAdapter: InitializeDataAdapter):
            InitializeDataUseCase

}