package beca.thyagoluis.becamobile.presentation.heroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isGone
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

        val viewModel: HeroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)

        viewModel.heroesLiveData.observe(this, Observer {
            it?.let{ heroes ->
                with(recyclerHeroes) {
                    layoutManager = LinearLayoutManager(this@HeroesActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = HeroesAdapter(heroes)
                    progressBar.visibility = View.GONE
                }
            }
        })

        viewModel.getHeroes()

    }
}