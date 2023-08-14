package kirishhaa.viewwave.data.entity.movie

import com.google.gson.annotations.SerializedName

class GenreDataEntity(
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int,
)