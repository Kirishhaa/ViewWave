package kirishhaa.viewwave.data.entity.movie

import com.google.gson.annotations.SerializedName

class MovieReviewDataEntity(
    @SerializedName("author")
    private val author: String,
    @SerializedName("avatar_path")
    private val avatarPath: String,
    @SerializedName("rating")
    private val rating: Int,
    @SerializedName("content")
    private val content: String,
    @SerializedName("created_at")
    private val createdAt: String
)