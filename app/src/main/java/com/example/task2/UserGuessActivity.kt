package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class UserGuessActivity : AppCompatActivity() {

    private var targetNumber = 0
    private var attempts = 0
    private val TAG = "UserGuessActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_user_guess)

        targetNumber = (1..100).random()
        Log.d(TAG, "Загаданное число: $targetNumber")

        val editGuess: EditText = findViewById(R.id.edit_guess)
        val buttonSubmit: Button = findViewById(R.id.button_submit_guess)
        val textResult: TextView = findViewById(R.id.text_result)

        buttonSubmit.setOnClickListener {
            val guessStr = editGuess.text.toString()
            if (guessStr.isNotEmpty()) {
                val guess = guessStr.toInt()
                attempts++
                when {
                    guess > targetNumber -> {
                        textResult.text = "Меньше"
                        Log.d(TAG, "Пользователь ввел $guess: Нужно меньше")
                    }
                    guess < targetNumber -> {
                        textResult.text = "Больше"
                        Log.d(TAG, "Пользователь ввел $guess: Нужно больше")
                    }
                    else -> {
                        textResult.text = "Поздравляем! Вы угадали число за $attempts попыток."
                        Log.d(TAG, "Пользователь угадал число $targetNumber за $attempts попыток")
                    }
                }
            } else {
                Toast.makeText(this, "Введите число", Toast.LENGTH_SHORT).show()
            }
        }
    }
}