package beca.thyagoluis.becamobile.presentation.heroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import beca.thyagoluis.becamobile.data.ApiService
import beca.thyagoluis.becamobile.data.model.Hero
import beca.thyagoluis.becamobile.data.response.HeroesBodyResponse
import beca.thyagoluis.becamobile.data.response.HeroesResultsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesViewModel : ViewModel() {

    val heroesLiveData: MutableLiveData<List<Hero>> = MutableLiveData()

    fun getHeroes() {
        ApiService.service.getHeroes().enqueue(object : Callback<HeroesBodyResponse> {
            override fun onResponse(
                call: Call<HeroesBodyResponse>,
                response: Response<HeroesBodyResponse>
            ) {
                if (response.isSuccessful) {
                    val heroes: MutableList<Hero> = mutableListOf()

                    response.body()?.let { heroBodyResponse ->
                        for (result in heroBodyResponse.data.results) {
                            val hero = Hero(
                                name = result.name,
                                description = result.description,
                                thumbnail = result.thumbnail.path + "/standard_amazing." + result.thumbnail.extension
                            )

                            heroes.add(hero)
                        }
                    }

                    heroesLiveData.value = heroes
                }
            }

            override fun onFailure(call: Call<HeroesBodyResponse>, t: Throwable) {
            }

        })
    }
}