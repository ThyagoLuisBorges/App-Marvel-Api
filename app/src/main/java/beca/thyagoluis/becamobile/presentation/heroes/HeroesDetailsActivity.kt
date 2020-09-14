package beca.thyagoluis.becamobile.presentation.heroes

import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import beca.thyagoluis.becamobile.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_heroes.*
import kotlinx.android.synthetic.main.activity_heroes_details.*
import java.security.AccessControlContext

class HeroesDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes_details)

        toolbarDetails.title = getString(R.string.toolbar_title)
        setSupportActionBar(toolbarDetails)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val thumbnail = intent.getStringExtra(EXTRA_THUMBNAIL)?.split(":")

        textHeroName.text = name

        if(description.isNullOrEmpty()) {
            textHeroDescription.text = "Personagem sem descrição"
        } else {
            textHeroDescription.text = description
        }

        Glide
            .with(this.applicationContext)
            .load("https:" + (thumbnail?.get(1) ?: thumbnail))
            .centerCrop()
            .into(imageHeroAvatar);
    }

    companion object {
        private const val EXTRA_NAME = "EXTRA_NAME"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"
        private const val EXTRA_THUMBNAIL = "EXTRA_THUMBNAIL"

        fun getStartIntent(context: Context, name: String, description: String, thumbnail: String): Intent {
            return Intent(context, HeroesDetailsActivity::class.java).apply {
                putExtra(EXTRA_NAME, name)
                putExtra(EXTRA_DESCRIPTION, description)
                putExtra(EXTRA_THUMBNAIL, thumbnail)
            }
        }
    }
}