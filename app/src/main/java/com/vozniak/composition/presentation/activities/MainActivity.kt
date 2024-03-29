package com.vozniak.composition.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vozniak.composition.databinding.ActivityMainBinding
import com.vozniak.composition.domain.usecases.GenerateQuestionsUseCase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



}