package com.example.hw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val logTag = "MainActivity"
    private val numberKey = "number"
    private var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNumber(savedInstanceState)
        setupButton()

        Log.d(logTag, "Created with number $number")
    }

    private fun setupNumber(savedInstanceState: Bundle?) {
        number = savedInstanceState?.getInt(numberKey) ?: 0
        val numberText = findViewById<TextView>(R.id.numberText)
        numberText.text = number.toString()
    }

    private fun setupButton() {
        val squareButton = findViewById<Button>(R.id.numberButton)
        squareButton.setOnClickListener {
            val intent = Intent(this, SquareActivity::class.java)
                .apply { putExtra(numberKey, number) }
            startActivity(intent)
        }
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (isChangingConfigurations) {
            number++
        }
        outState.putInt(numberKey, number)
        Log.d(logTag, "Instance saved with number $number")
    }
}