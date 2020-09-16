package beca.thyagoluis.becamobile.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroesBodyResponse(
    @Json(name = "data")
    val data: HeroesDataResponse
)