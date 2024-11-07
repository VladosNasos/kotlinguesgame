package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.util.Log
import com.example.task2.UserGuessActivity

class GameModeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("GameModeActivity", "onCreate called")
        setContentView(R.layout.activity_game_mode)

        val buttonUserGuess: Button = findViewById(R.id.button_user_guess)
        val buttonAndroidGuess: Button = findViewById(R.id.button_android_guess)

        buttonUserGuess.setOnClickListener {
            val intent = Intent(this, UserGuessActivity::class.java)
            startActivity(intent)
        }

        buttonAndroidGuess.setOnClickListener {
            val intent = Intent(this, AndroidGuessActivity::class.java)
            startActivity(intent)
        }
    }
}