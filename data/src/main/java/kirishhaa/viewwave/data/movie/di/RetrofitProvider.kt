package kirishhaa.viewwave.data.movie.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kirishhaa.viewwave.core.URLProvider.QUERY.BASE_URL_QUERY
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitProvider {

    private fun provideInterceptor() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private fun provideClient() = OkHttpClient.Builder()
        .addInterceptor(provideInterceptor())
        .build()

    private fun provideGson() = Gson()

    private fun provideGsonConverter() = GsonConverterFactory.create(provideGson())

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_QUERY)
        .client(provideClient())
        .addConverterFactory(provideGsonConverter())
        .build()

}