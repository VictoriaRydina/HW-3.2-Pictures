package com.example.hw_32_pictures

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_32_pictures.databinding.ActivityMainBinding
import java.net.URI

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setImageURI(uri: URI){
        val uri: Uri = Uri.parse("android.resource://$packageName/${binding.image}")
        binding.image.setImageURI(null)
        binding.image.setImageURI(uri)
    }
}