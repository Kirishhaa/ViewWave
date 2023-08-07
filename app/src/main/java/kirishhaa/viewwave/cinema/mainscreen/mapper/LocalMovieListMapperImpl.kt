package kirishhaa.viewwave.cinema.mainscreen.mapper

import kirishhaa.viewwave.core.URLProvider.IMAGES.BASE_URL_IMAGE
import kirishhaa.viewwave.core.URLProvider.IMAGES.POSTER_SIZE_W342
import kirishhaa.viewwave.core.URLProvider.IMAGES.POSTER_SIZE_W500
import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kirishhaa.viewwave.main_screen.data.MovieListItem
import javax.inject.Inject

class LocalMovieListMapperImpl @Inject constructor(): LocalMovieListMapper {

    override fun mapToMovieListItem(localMovieList: MovieListDataEntity): List<MovieListItem> {
        return localMovieList.movieList.map {localMovieData ->
            MovieListItem(
                id = localMovieData.id,
                imagePath = BASE_URL_IMAGE+POSTER_SIZE_W342+localMovieData.posterPath,
                title = localMovieData.title,
                rate = localMovieData.voteAverage.toString()
            )
        }
    }

}