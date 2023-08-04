package kirishhaa.viewwave.data.movie.datasource

import kirishhaa.viewwave.core.URLProvider.ACCEPT
import kirishhaa.viewwave.core.URLProvider.AUTHORIZATION
import kirishhaa.viewwave.core.URLProvider.DISCOVER_MOVIE
import kirishhaa.viewwave.core.URLProvider.HEADER_TOKEN
import kirishhaa.viewwave.core.URLProvider.TYPE_HEADER
import kirishhaa.viewwave.core.UnsuccessfulDiscoverMovie
import kirishhaa.viewwave.core.logE
import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(
    private val retrofit: Retrofit
): MovieDataSource {

    private interface Api {

        @Headers(
            "$ACCEPT: $TYPE_HEADER",
            "$AUTHORIZATION: Bearer $HEADER_TOKEN"
        )
        @GET(DISCOVER_MOVIE)
        suspend fun discoverMovie(
            @Query("include_adult") includeAdult: Boolean?=null,
            @Query("include_video") includeVideo: Boolean?=null,
            @Query("language") language: String?=null,
            @Query("page") page: Int=1,
            @Query("sort_by") sortBy: String?=null
        ): Response<MovieListDataEntity>

    }

    override suspend fun discoverMovie(
        includeAdult: Boolean?,
        includeVideo: Boolean?,
        language: String?,
        page: Int,
        sortBy: String?,
    ): MovieListDataEntity {
        val response = retrofit.create(Api::class.java)
            .discoverMovie(includeAdult, includeVideo, language, page, sortBy)

        val isSuccessful = response.isSuccessful
        if(!isSuccessful) {
            logE("unsuccessful discover movie")
            throw UnsuccessfulDiscoverMovie()
        } else {
            try {
             return response.body()!!
            } catch (e: Exception) {
                logE("null response body exception")
                throw UnsuccessfulDiscoverMovie()
            }
        }
    }

}