package beca.thyagoluis.becamobile.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroesThumbnail(
    @Json(name = "path")
    val path: String,
    @Json(name = "extension")
    val extension: String
)