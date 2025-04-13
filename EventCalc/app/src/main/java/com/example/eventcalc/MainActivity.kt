package com.example.eventcalc

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Install splash screen (for Android 12+)
        val splashScreen = SplashScreen.installSplashScreen(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Optional: Hide status bar for immersive splash
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Find views
        val logoImageView = findViewById<ImageView>(R.id.ivLogo)
        val appNameTextView = findViewById<TextView>(R.id.tvAppName)
        val taglineTextView = findViewById<TextView>(R.id.tvTagline)

        // Create fade-in animation for logo
        val fadeIn = AlphaAnimation(0.0f, 1.0f)
        fadeIn.duration = 1500

        // Start animation
        logoImageView.startAnimation(fadeIn)

        // When logo fade-in ends, fade in text and then go to main screen
        fadeIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                val textFadeIn = AlphaAnimation(0.0f, 1.0f)
                textFadeIn.duration = 1000
                appNameTextView.startAnimation(textFadeIn)
                taglineTextView.startAnimation(textFadeIn)

                // Wait, then move to HomeActivity (or main screen)
                Handler(Looper.getMainLooper()).postDelayed({
                    // Uncomment these lines when you create HomeActivity
                    // val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    // startActivity(intent)
                    // finish()
                }, 2000)
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}
