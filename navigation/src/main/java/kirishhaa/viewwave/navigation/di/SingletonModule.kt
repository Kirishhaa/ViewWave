package kirishhaa.viewwave.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.navigation.domain.ActivityLifecycleExecutor
import kirishhaa.viewwave.navigation.domain.TagFragmentManager

@Module
@InstallIn(SingletonComponent::class)
internal class SingletonModule {

    @Provides
    fun provideActivityLifecycleExecutor() = ActivityLifecycleExecutor

    @Provides
    fun provideTagFragmentManager() = TagFragmentManager

}