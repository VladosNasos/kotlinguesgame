package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private var startTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startTime = System.currentTimeMillis()
        Log.d(TAG, "onCreate called at $startTime ms")
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button_click_me)
        button.setOnClickListener {
            Log.d(TAG, "Кнопка была нажата")
        }
    }

    override fun onStart() {
        super.onStart()
        val currentTime = System.currentTimeMillis()
        Log.d(TAG, "onStart called at $currentTime ms")
        Log.d(TAG, "Time since onCreate: ${currentTime - startTime} ms")
    }

    override fun onResume() {
        super.onResume()
        val currentTime = System.currentTimeMillis()
        Log.d(TAG, "onResume called at $currentTime ms")
        Log.d(TAG, "Time since onStart: ${currentTime - startTime} ms")
    }

    override fun onPause() {
        super.onPause()
        val currentTime = System.currentTimeMillis()
        Log.d(TAG, "onPause called at $currentTime ms")
    }

    override fun onStop() {
        super.onStop()
        val currentTime = System.currentTimeMillis()
        Log.d(TAG, "onStop called at $currentTime ms")
    }

    override fun onDestroy() {
        super.onDestroy()
        val currentTime = System.currentTimeMillis()
        Log.d(TAG, "onDestroy called at $currentTime ms")
    }

    override fun onRestart() {
        super.onRestart()
        val currentTime = System.currentTimeMillis()
        Log.d(TAG, "onRestart called at $currentTime ms")
    }
}