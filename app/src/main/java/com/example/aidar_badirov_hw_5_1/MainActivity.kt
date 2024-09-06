package com.example.aidar_badirov_hw_5_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aidar_badirov_hw_5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContract {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachContract(this)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIncrement()
            }

            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
        }
    }

    override fun updateCount(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeColor(color: Int) {
        binding.tvCount.setTextColor(color)
    }

    override fun onDestroy() {
        presenter.detachContract()
        super.onDestroy()
    }
}