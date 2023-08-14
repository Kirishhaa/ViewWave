package kirishhaa.viewwave.data.entity.movie

import com.google.gson.annotations.SerializedName

class MovieCreditsDataEntity(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String,
    @SerializedName("profile_path")
    private val profilePath: String,
    @SerializedName("character")
    private val character: String,
)