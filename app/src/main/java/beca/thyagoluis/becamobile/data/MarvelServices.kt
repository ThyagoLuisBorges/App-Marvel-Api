package beca.thyagoluis.becamobile.data

import beca.thyagoluis.becamobile.data.response.HeroesBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelServices {

    @GET("characters")
    fun getHeroes(
        @Query("ts") ts: String = "231908329018",
        @Query("apikey") apiKey: String = "53f4971cfa095301fbad2115de9ca7b5",
        @Query("hash") hash: String = "f84e91792e91844eb5faaf8a6271d637",
    ): Call<HeroesBodyResponse>

}