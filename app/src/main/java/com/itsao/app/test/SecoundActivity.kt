package com.itsao.app.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itsao.app.test.databinding.ActivitySecoundBinding
import com.itsao.app.test.utils.launchActivity

class SecoundActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecoundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecoundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clickMe.setOnClickListener {
            launchActivity<MainActivity>()
        }
    }
}