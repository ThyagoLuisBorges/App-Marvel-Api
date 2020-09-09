package beca.thyagoluis.becamobile.presentation.start

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import beca.thyagoluis.becamobile.R
import beca.thyagoluis.becamobile.presentation.heroes.HeroesActivity
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class InitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        window.insetsController?.hide(WindowInsets.Type.statusBars())

        val worker: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
        val runnable = Runnable {
            val intent = Intent(this, HeroesActivity::class.java)
            startActivity(intent)
            finish()
        }
        worker.schedule(runnable, 5, TimeUnit.SECONDS)
    }
}