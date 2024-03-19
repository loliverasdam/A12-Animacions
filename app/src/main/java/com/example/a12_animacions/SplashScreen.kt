package com.example.a12_animacions

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.example.a12_animacions.databinding.ActivitySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView((binding.root))

        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.main_animation)

        binding.ball.startAnimation(animation)

        binding.ball.setOnClickListener(){
            if (animation.hasEnded()){
                window.decorView.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fade_out))
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }
        }
    }
}