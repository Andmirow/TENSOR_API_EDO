package com.example.tensor_api_edo.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tensor_api_edo.databinding.AuthenticateFormBinding
import com.example.tensor_api_edo.domain.FilmApp


class AuthenticateFragment : Fragment() {

    private lateinit var viewModel: AuthenticateViewModel
    lateinit var binding : AuthenticateFormBinding
    private lateinit var howToCloseFragment : HowToCloseFragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HowToCloseFragment) {
            howToCloseFragment = context
        } else {
            throw RuntimeException("Activity must implement OnEditingFinishedListener")
        }
    }


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
        binding.btAuthenticate.setOnClickListener {
            var login = binding.etLogin.editText?.text.toString()
            var password = binding.etPassword.editText?.text.toString()
            viewModel.authenticate((activity?.application as FilmApp).apiEdo,login,password)
        }

        viewModel.isSuccess.observe(viewLifecycleOwner) {
            if (it) {
                howToCloseFragment.closeFragment()
            }
        }
    }



}