package com.example.hw_32_pictures

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.hw_32_pictures.databinding.ActivityMainBinding
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var urlIm = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageUpload()
        deleteLink()
    }

    private fun deleteLink(){
        binding.buttonDel.setOnClickListener {
            binding.link.text.clear()
            binding.image.setImageBitmap(null)
        }
    }

    private fun imageUpload(){
        binding.button.setOnClickListener {
            urlIm = binding.link.text.toString()

            if (urlIm.isNotEmpty()){
                Picasso.get()
                    .load(urlIm)
                    .memoryPolicy(MemoryPolicy.NO_CACHE)
                    .error(R.drawable.city)
                    .into(binding.image)
            }else {
                Toast.makeText(this, "Loading error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}