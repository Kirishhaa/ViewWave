package kirishhaa.viewwave.data.entity.movie

import com.google.gson.annotations.SerializedName

class MovieListDataEntity(
    @SerializedName("page")
    val currentPage: Int,
    @SerializedName("results")
    val movieList: List<MovieDataEntity>
)