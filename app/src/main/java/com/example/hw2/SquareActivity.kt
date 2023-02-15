package com.example.hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView


class SquareActivity : AppCompatActivity() {

    private val logTag = "SquareActivity"
    private val numberKey = "number"
    private var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        setupNumber()
        setupButton()

        Log.d(logTag, "Created with number $number")
    }

    private fun setupNumber() {
        val numberText = findViewById<TextView>(R.id.numberText)
        number = intent.getIntExtra(numberKey, 0)
        val textToDisplay = "$number\u00B2 = ${number * number}"
        numberText.text = textToDisplay
    }

    private fun setupButton() {
        val numberButton = findViewById<Button>(R.id.numberButton)
        numberButton.setOnClickListener { finish() }
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag, "Started")

    }

    override fun onResume() {
        super.onResume()
        Log.d(logTag, "Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d(logTag, "Paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logTag, "Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logTag, "Destroyed")
    }
}