package kirishhaa.viewwave.data.entity.actors

import com.google.gson.annotations.SerializedName

class ActorDataEntity(
    @SerializedName("biography")
    private val biography: String,
    @SerializedName("birthday")
    private val birthday: String,
    @SerializedName("deathday")
    private val deathday: String?,
    @SerializedName("name")
    private val name: String,
    @SerializedName("place_of_bith")
    private val placeOfBirth: String,
    @SerializedName("profile_path")
    private val profilePath: String
)