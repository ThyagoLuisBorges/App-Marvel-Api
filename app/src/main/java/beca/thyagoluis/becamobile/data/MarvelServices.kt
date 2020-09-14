package beca.thyagoluis.becamobile.data

import android.util.Log
import androidx.annotation.Nullable
import beca.thyagoluis.becamobile.data.response.HeroesBodyResponse
import beca.thyagoluis.becamobile.data.util.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.security.NoSuchAlgorithmException
import java.util.*

interface MarvelServices {

    @GET("characters")
    fun getHeroes(
        @Query("limit") limit: String = "100",
        @Query("ts") ts: String = TS,
        @Query("apikey") apiKey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()
    ): Call<HeroesBodyResponse>

    @GET("characters")
    fun getHero(
        @Query("nameStartsWith") name: String,
        @Query("ts") ts: String = TS,
        @Query("apikey") apiKey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH.md5()
    ): Call<HeroesBodyResponse>

}