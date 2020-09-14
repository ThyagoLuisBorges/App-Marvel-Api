package beca.thyagoluis.becamobile.presentation.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.Menu
import android.view.View
import android.widget.SearchView
import androidx.core.view.isGone
import androidx.core.view.isNotEmpty
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import beca.thyagoluis.becamobile.R
import beca.thyagoluis.becamobile.data.model.Hero
import kotlinx.android.synthetic.main.activity_heroes.*
import kotlin.math.log

class HeroesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        toolbarMain.title = getString(R.string.toolbar_title)
        setSupportActionBar(toolbarMain)

        progressBar.visibility = View.VISIBLE

        refreshLayout.setOnRefreshListener {
            fetchHeroes()
        }

        fetchHeroes()

    }

    private fun fetchHeroes(){
        val viewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)

        viewModel.heroesLiveData.observe(this, Observer {
            it?.let{ heroes ->
                with(recyclerHeroes) {
                    layoutManager = LinearLayoutManager(this@HeroesActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = HeroesAdapter(heroes) { hero ->
                        val intent = HeroesDetailsActivity.getStartIntent(this@HeroesActivity, hero.name, hero.description, hero.thumbnail)
                        this@HeroesActivity.startActivity(intent)
                    }
                    progressBar.visibility = View.GONE
                }
            }
        })

        refreshLayout.isRefreshing = false

        viewModel.getHeroes(applicationContext)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main, menu)
        val searchItem = menu?.findItem(R.id.search)

        val viewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)

        if(searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(hero: String?): Boolean {
                    if(!hero.isNullOrEmpty()) {
                        viewModel.getHero(hero, applicationContext)
                    }
                    return true
                }

                override fun onQueryTextChange(hero: String?): Boolean {
                    return true
                }

            })
        }

        return super.onCreateOptionsMenu(menu)
    }
}