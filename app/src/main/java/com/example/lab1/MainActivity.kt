package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isTextVisible: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun btnOnClick(view: View?) {
        if (isTextVisible) {
            binding.tvHelloWorld.visibility = View.INVISIBLE
            binding.btnFlip.text = "Show"
        }
        else {
            binding.tvHelloWorld.visibility = View.VISIBLE
            binding.btnFlip.text = "Hide"
        }

        isTextVisible = !isTextVisible
    }

    fun labTwoOnClick(view: View?) {
        val intent = Intent(this, lab2::class.java)
        startActivity(intent)
    }
}