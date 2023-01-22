package com.example.tensor_api_edo.presentation.authenticate_view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tensor_api_edo.R
import com.example.tensor_api_edo.databinding.AuthenticateFormBinding
import com.example.tensor_api_edo.domain.MyApp
import com.example.tensor_api_edo.domain.SbisSetting
import com.example.tensor_api_edo.presentation.FragmentControl
import com.example.tensor_api_edo.presentation.ListComandFragment


class AuthenticateFragment : Fragment() {

    private lateinit var viewModel: AuthenticateViewModel
    lateinit var binding : AuthenticateFormBinding
    private lateinit var howToCloseFragment : FragmentControl

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentControl) {
            howToCloseFragment = context
        } else {
            throw RuntimeException("Activity must implement FragmentControl")
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthenticateViewModel::class.java)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = AuthenticateFormBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //howToCloseFragment.closeAndOpenNewFragment(ListComandFragment.newInstance()) //АА если есть активная сессия

        binding.btAuthenticate.setOnClickListener {
            var login = binding.etLogin.editText?.text.toString()
            var password = binding.etPassword.editText?.text.toString()
            viewModel.authenticate((activity?.application as MyApp).apiEdo,login,password)
        }

        viewModel.isSuccess.observe(viewLifecycleOwner) {
            if (it) {
                SbisSetting.isAuthenticate = true
                //howToCloseFragment.closeAndOpenNewFragment(ListComandFragment.newInstance())
                findNavController().navigate(R.id.action_authenticateFragment_to_listComandFragment)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            AuthenticateFragment().apply {
                arguments = Bundle()
            }
    }


}