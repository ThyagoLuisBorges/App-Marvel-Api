package beca.thyagoluis.becamobile.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HeroesBodyResponse(
    @Json(name = "results")
    val heroResult: List<HeroesResultsResponse>
)