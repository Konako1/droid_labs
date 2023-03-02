package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lab1.databinding.ActivityLab2Binding
import kotlin.math.abs
import kotlin.math.round
import kotlin.math.sign
import kotlin.math.sqrt

class lab2 : AppCompatActivity() {

    private lateinit var binding: ActivityLab2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLab2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun labOneOnClick(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun numAsText(_num: Double, position: Int): String {
        var num = _num
        var sign = ""
        if (num < 0.0) {
            sign = "-"
            num = abs(num)
        }
        else {
            if (position != 0) {
                sign = "+"
            }
        }

        if (abs(num) == 1.0 && position != 2) {
            return if (position == 0) sign else "$sign "
        }
        return if (position == 0) "$sign$num" else "$sign $num"
    }

    fun calculate(view: View?) {
        val _a = binding.etA.text.toString()
        val _b = binding.etB.text.toString()
        val _c = binding.etC.text.toString()

        // проверочки
        if (_a == "" || _a.toDouble() == 0.0) {
            binding.etA.error = "Can't be null"
            binding.etA.requestFocus()
            return
        }

        // решение
        if (_b == "" && _c == "") {
            binding.tvResult.text = "${numAsText(_a.toDouble(), 0)}x^2 = 0\nx = 0"
            return
        }
        if (_b == "") {
            if ((_c.toInt() * -1) / _a.toInt() < 0) {
                binding.tvResult.text = "${numAsText(_a.toDouble(), 0)}x^2 ${numAsText(_c.toDouble(), 2)} = 0\n" +
                        "Нет корней"
                return
            }
            else {
                val sqrt = sqrt(((_c.toInt() * -1) / _a.toInt()).toDouble())
                binding.tvResult.text = "${numAsText(_a.toDouble(), 0)}x^2 ${numAsText(_c.toDouble(), 2)} = 0\n" +
                        "x1 = -${round(sqrt)}\n" +
                        "x2 = ${round(sqrt)}"
                return
            }
        }
        if (_c == "") {
            binding.tvResult.text = "${numAsText(_a.toDouble(), 0)}x^2 ${numAsText(_b.toDouble(), 1)}x = 0\n" +
                    "x1 = 0\n" +
                    "x2 = ${_b.toDouble() * -1 / _a.toDouble()}"
            return
        }

        val a = _a.toDouble()
        val b = _b.toDouble()
        val c = _c.toDouble()

        val d: Double = b*b - 4*a*c
        val expr = "${numAsText(_a.toDouble(), 0)}x^2 ${numAsText(_b.toDouble(), 1)}x ${numAsText(_c.toDouble(), 2)} = 0"
        if (d < 0) {
            binding.tvResult.text = "${expr}\n" +
                    "Дискриминант меньше 0, корней нет."
        }
        else if (d == 0.0) {
            binding.tvResult.text = "${expr}\nx = ${-1 * b / (2 * a)}"
        }
        else {
            binding.tvResult.text = "${expr}\n" +
                    "x1 = ${(-1 * b + sqrt(d)) / (2 * a)}\n" +
                    "x2 = ${(-1 * b - sqrt(d)) / (2 * a)}"
        }
    }
}