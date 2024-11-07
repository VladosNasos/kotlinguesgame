package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.util.Log

class AndroidGuessActivity : AppCompatActivity() {

    private var min = 1
    private var max = 100
    private var guess = 0
    private var attempts = 0
    private val TAG = "AndroidGuessActivity"

    private lateinit var textQuestion: TextView
    private lateinit var buttonHigher: Button
    private lateinit var buttonLower: Button
    private lateinit var buttonCorrect: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_android_guess)

        textQuestion = findViewById(R.id.text_question)
        buttonHigher = findViewById(R.id.button_higher)
        buttonLower = findViewById(R.id.button_lower)
        buttonCorrect = findViewById(R.id.button_correct)

        makeGuess()

        buttonHigher.setOnClickListener {
            if (guess < max) {
                min = guess + 1
                Log.d(TAG, "Пользователь указал, что число больше $guess")
                makeGuess()
            } else {
                Toast.makeText(this, "Некорректный ввод", Toast.LENGTH_SHORT).show()
            }
        }

        buttonLower.setOnClickListener {
            if (guess > min) {
                max = guess - 1
                Log.d(TAG, "Пользователь указал, что число меньше $guess")
                makeGuess()
            } else {
                Toast.makeText(this, "Некорректный ввод", Toast.LENGTH_SHORT).show()
            }
        }

        buttonCorrect.setOnClickListener {
            attempts++
            textQuestion.text = "Ура! Я угадал число $guess за $attempts попыток."
            Log.d(TAG, "Android угадал число $guess за $attempts попыток")
            disableButtons()
        }
    }

    private fun makeGuess() {
        if (min > max) {
            textQuestion.text = "Кажется, вы где-то ошиблись!"
            disableButtons()
            Log.d(TAG, "Диапазон некорректен: min=$min, max=$max")
            return
        }
        guess = (min + max) / 2
        attempts++
        textQuestion.text = "Ваше число это $guess?"
        Log.d(TAG, "Android предполагает число $guess")
    }

    private fun disableButtons() {
        buttonHigher.isEnabled = false
        buttonLower.isEnabled = false
        buttonCorrect.isEnabled = false
    }
}