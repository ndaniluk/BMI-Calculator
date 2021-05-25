package com.example.bmi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log

class SplashScreen : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        val starter = ActivityStarter()
        starter.start()
    }

    private inner class ActivityStarter : Thread() {
        override fun run() {
            try {
                sleep(splashScreenTimer.toLong())
            } catch (e: Exception) {
                Log.e("SplashScreen", e.message.toString())
            }
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            this@SplashScreen.startActivity(intent)
            finish()
        }
    }

    companion object {
        private const val splashScreenTimer = 2000
    }
}