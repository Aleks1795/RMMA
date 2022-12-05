package com.ruslanchikbananchik.rmma

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ruslanchikbananchik.rmma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.helloAndroid.text = getString(R.string.hello_android, Build.VERSION.RELEASE)
    }
}