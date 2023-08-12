package kirishhaa.viewwave.cinema.mainscreen.mapper

import kirishhaa.viewwave.data.entity.movie.MovieDataEntity
import kirishhaa.viewwavemovie_details_screen.data.MovieDetail

interface MovieDataEntityMapper {

    suspend fun mapToMovieDetail(movieDataEntity: MovieDataEntity): MovieDetail

}