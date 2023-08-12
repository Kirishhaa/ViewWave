package kirishhaa.viewwave.cinema.mainscreen.mapper

import kirishhaa.viewwave.data.entity.movie.MovieListDataEntity
import kirishhaa.viewwave.main_screen.data.MovieListItem

interface MovieListDataEntityMapper {

    fun mapToMovieListItem(localMovieList: MovieListDataEntity): List<MovieListItem>


}