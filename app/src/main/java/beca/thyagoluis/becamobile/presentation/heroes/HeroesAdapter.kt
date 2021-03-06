package beca.thyagoluis.becamobile.presentation.heroes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import beca.thyagoluis.becamobile.R
import beca.thyagoluis.becamobile.data.model.Hero
import beca.thyagoluis.becamobile.data.response.HeroesBodyResponse
import beca.thyagoluis.becamobile.data.response.HeroesDataResponse
import beca.thyagoluis.becamobile.data.response.HeroesResultsResponse
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.heroes_list.view.*

class HeroesAdapter(
    private val heroes: List<Hero>,
    private val onItemClickListener: ((hero: Hero) -> Unit)
) : RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.heroes_list, parent, false)

        return HeroesViewHolder(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bindView(heroes[position])
    }

    override fun getItemCount() = heroes.count()

    class HeroesViewHolder(view: View, private val onItemClickListener: ((hero: Hero) -> Unit)) :
        RecyclerView.ViewHolder(view) {

        private val heroName = view.textHeroName
        private val imageAvatar = view.imageViewHero

        fun bindView(hero: Hero) {
            heroName.text = hero.name

            val thumbnail = hero.thumbnail.split(":")

            Glide
                .with(itemView)
                .load("https:" + thumbnail[1])
                .centerCrop()
                .into(imageAvatar);

            itemView.setOnClickListener {
                onItemClickListener.invoke(hero)
            }
        }
    }
}