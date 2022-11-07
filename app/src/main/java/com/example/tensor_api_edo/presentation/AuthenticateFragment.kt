package com.example.tensor_api_edo.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tensor_api_edo.databinding.AuthenticateFormBinding
import com.example.tensor_api_edo.domain.FilmApp
import kotlinx.android.synthetic.main.authenticate_form.view.*

class AuthenticateFragment : Fragment() {

    private lateinit var viewModel: AuthenticateViewModel
    lateinit var binding : AuthenticateFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthenticateViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = AuthenticateFormBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val login = binding.etLogin.text.toString()
        val password = binding.etPassword.text.toString()
        binding.btAuthenticate.setOnClickListener {
            viewModel.authenticate((activity?.application as FilmApp).apiEdo,login,password)
        }

    }



}