package com.example.tensor_api_edo.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tensor_api_edo.databinding.ActivityMainBinding
import com.example.tensor_api_edo.databinding.AuthenticateFormBinding
import com.example.tensor_api_edo.databinding.ListComandBinding

class ListComand : AppCompatActivity() {

    lateinit var binding : ListComandBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ListComandBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.incoming.setOnClickListener {

        }
        binding.outcoming.setOnClickListener {

        }
        binding.button3.setOnClickListener {

        }
        binding.vok.setOnClickListener {

        }


    }

    companion object{
        fun newList(context : Context): Intent {
            return Intent(context, ListComand::class.java)
        }
    }
}