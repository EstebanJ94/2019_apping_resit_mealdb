package fr.epita.android.mealdbapp.presentation.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import fr.epita.android.mealdbapp.presentation.home.Home
import fr.epita.android.mealdbapp.R


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        stimulateSomeWork()
    }

    private fun stimulateSomeWork() {
        Handler().postDelayed(Runnable {
            startActivity(Intent(this@Splash, Home::class.java))
            finish()
        }, 3000)
    }
}
