package com.example.tensor_api_edo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tensor_api_edo.databinding.AuthenticateFormBinding
import com.example.tensor_api_edo.databinding.ListComandBinding

class ListComand : Fragment() {

    lateinit var binding : ListComandBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ListComandBinding.inflate(inflater,container,false)
        return binding.root
    }

}