package beca.thyagoluis.becamobile.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroesDataResponse(
    @Json(name = "results")
    val results: List<HeroesResultsResponse>
)