package kirishhaa.viewwave.cinema.mainscreen.mapper

import kirishhaa.viewwave.core.URLProvider.IMAGES.BACKDROP_SIZE_W300
import kirishhaa.viewwave.core.URLProvider.IMAGES.BASE_URL_IMAGE
import kirishhaa.viewwave.core.URLProvider.IMAGES.POSTER_SIZE_W185
import kirishhaa.viewwave.data.entity.movie.GenreDataEntity
import kirishhaa.viewwave.data.entity.movie.MovieDataEntity
import kirishhaa.viewwavemovie_details_screen.data.MovieDetail
import javax.inject.Inject

class MovieDataEntityMapperImpl @Inject constructor() : MovieDataEntityMapper {

    override suspend fun mapToMovieDetail(movieDataEntity: MovieDataEntity): MovieDetail {
        val posterPath = BASE_URL_IMAGE + POSTER_SIZE_W185 + movieDataEntity.posterPath
        val backdropPath = BASE_URL_IMAGE + BACKDROP_SIZE_W300 + movieDataEntity.backdropPath
        val genres = getFormattedGenres(movieDataEntity.genres!!)
        val adult = movieDataEntity.adult.toString()

        val runtime = getFormattedRuntime(movieDataEntity.runtime)
        val voteAverage = movieDataEntity.voteAverage.toString()
        val voteCount = movieDataEntity.voteCount.toString()

        return MovieDetail(
            adult = adult,
            backdropPath = backdropPath,
            genres = genres,
            originalLanguage = movieDataEntity.originalLanguage,
            originalTitle = movieDataEntity.originalTitle,
            overview = movieDataEntity.overview,
            posterPath = posterPath,
            releaseDate = movieDataEntity.releaseDate,
            title = movieDataEntity.title,
            voteAverage = voteAverage,
            voteCount = voteCount,
            runtime = runtime
        )

    }

    private fun getFormattedGenres(genres: List<GenreDataEntity>): String {
        val genresValues = genres.map { it.name }
        val builder = StringBuilder()
        genresValues.forEachIndexed { index, value ->
            builder.append(value)
            if (index != genresValues.size - 1) builder.append(", ")
        }
        return builder.toString()
    }

    private fun getFormattedRuntime(runtime: Int?): String {
        if (runtime == null) {
            return "-"
        } else {

            val hours = runtime / 60
            val minutes = runtime % 60

            val hoursValue = hours.toString()
            val minutesValue = if (minutes < 10) "0$minutes" else minutes.toString()

            return "$hoursValue:$minutesValue"
        }
    }

}