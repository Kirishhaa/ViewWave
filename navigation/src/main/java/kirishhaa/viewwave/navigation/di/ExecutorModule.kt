package kirishhaa.viewwave.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.navigation.presentation.ActivityLifecycleExecutor

@Module
@InstallIn(SingletonComponent::class)
class ExecutorModule {

    @Provides
    fun provideExecutor() = ActivityLifecycleExecutor

}