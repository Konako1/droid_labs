package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun btnOnClick(view: View?) {
        val text = binding.editText.text

        binding.textView.visibility = View.VISIBLE
        binding.textView.text = text
        binding.editText.text = null
    }

    fun labTwoOnClick(view: View?) {
        val intent = Intent(this, lab2::class.java)
        startActivity(intent)
    }
}