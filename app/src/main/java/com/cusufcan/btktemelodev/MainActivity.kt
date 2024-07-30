package com.cusufcan.btktemelodev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cusufcan.btktemelodev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerListeners()
    }

    private fun registerListeners() {
        binding.plusButton.setOnClickListener { calculateResult("+") }

        binding.divideButton.setOnClickListener { calculateResult("/") }

        binding.multiplyButton.setOnClickListener { calculateResult("*") }

        binding.minusButton.setOnClickListener { calculateResult("-") }
    }

    private fun calculateResult(operation: String) {
        val numberrOne = binding.numberOneEditText.text.toString().toDouble()
        val numberTwo = binding.numberTwoEditText.text.toString().toDouble()

        val result = when (operation) {
            "+" -> numberrOne + numberTwo
            "-" -> numberrOne - numberTwo
            "*" -> numberrOne * numberTwo
            "/" -> numberrOne / numberTwo
            else -> 0.0
        }

        binding.textView.text = "Sonuç: $result"
    }
}