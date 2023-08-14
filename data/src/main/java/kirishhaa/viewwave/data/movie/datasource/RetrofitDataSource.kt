package kirishhaa.viewwave.data.movie.datasource

import kirishhaa.viewwave.core.URLProvider.QUERY.ACCEPT
import kirishhaa.viewwave.core.URLProvider.QUERY.AUTHORIZATION
import kirishhaa.viewwave.core.URLProvider.QUERY.DISCOVER_MOVIE
import kirishhaa.viewwave.core.URLProvider.QUERY.GET_MOVIE_BY_DETAIL
import kirishhaa.viewwave.core.URLProvider.QUERY.HEADER_TOKEN
import kirishhaa.viewwave.core.URLProvider.QUERY.TYPE_HEADER
import kirishhaa.viewwave.core.UnsuccessfulDiscoverMovie
import kirishhaa.viewwave.core.UnsuccessfulGetDetailMovie
import kirishhaa.viewwave.core.logE
import kirishhaa.viewwave.data.entity.movie.MovieDataEntity
import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(
    private val retrofit: Retrofit,
) : MovieDataSource {

    private interface Api {

        @Headers(
            "$ACCEPT: $TYPE_HEADER",
            "$AUTHORIZATION: Bearer $HEADER_TOKEN"
        )
        @GET(DISCOVER_MOVIE)
        suspend fun discoverMovie(
            @Query("include_adult") includeAdult: Boolean? = false,
            @Query("include_video") includeVideo: Boolean? = false,
            @Query("language") language: String? = null,
            @Query("page") page: Int? = 1,
            @Query("sort_by") sortBy: String? = null,
            @Query("with_genres") genreId: Int? = null,
        ): Response<MovieListDataEntity>

        @Headers(
            "$ACCEPT: $TYPE_HEADER",
            "$AUTHORIZATION: Bearer $HEADER_TOKEN"
        )
        @GET("$GET_MOVIE_BY_DETAIL/{id}")
        suspend fun getMovieDetailById(
            @Path("id") id: Int,
            @Query("language") language: String? = null,
        ): Response<MovieDataEntity>

    }

    override suspend fun discoverMovie(
        includeAdult: Boolean?,
        includeVideo: Boolean?,
        language: String?,
        page: Int?,
        sortBy: String?,
        genreId: Int?,
    ): MovieListDataEntity = withContext(Dispatchers.IO) {
        val response = retrofit.create(Api::class.java)
            .discoverMovie(includeAdult, includeVideo, language, page, sortBy, genreId)
        val isSuccessful = response.isSuccessful
        if (!isSuccessful) {
            logE("unsuccessful discover movie")
            throw UnsuccessfulDiscoverMovie()
        } else {
            try {
                return@withContext response.body()!!
            } catch (e: Exception) {
                logE("null body discoverMovie")
                throw UnsuccessfulDiscoverMovie(e)
            }
        }
    }

    override suspend fun getMovieDetailById(id: Int) = withContext(Dispatchers.IO) {
        val response = retrofit.create(Api::class.java)
            .getMovieDetailById(id)

        val isSuccessful = response.isSuccessful
        if (!isSuccessful) {
            logE("unsuccessful detail movie")
            throw UnsuccessfulGetDetailMovie()
        } else {
            try {
                return@withContext response.body()!!
            } catch (e: Exception) {
                logE("null body getMovieDetailById")
                throw UnsuccessfulGetDetailMovie(e)
            }
        }
    }

}