package kirishhaa.viewwave.data.entity.movie

import com.google.gson.annotations.SerializedName

class MovieDataEntity(
    @SerializedName("adult")
    private val adult: Boolean,
    @SerializedName("backdrop_path")
    private val backdropPath: String,
    @SerializedName("genre_ids")
    private val genreIds: IntArray,
    @SerializedName("id")
    private val id: Int,
    @SerializedName("original_language")
    private val originalLanguage: String,
    @SerializedName("original_title")
    private val originalTitle: String,
    @SerializedName("overview")
    private val overview: String,
    @SerializedName("poster_path")
    private val posterPath: String,
    @SerializedName("release_date")
    private val releaseDate: String,
    @SerializedName("title")
    private val title: String,
    @SerializedName("vote_average")
    private val voteAverage: Double,
    @SerializedName("vote_count")
    private val voteCount: Int
)