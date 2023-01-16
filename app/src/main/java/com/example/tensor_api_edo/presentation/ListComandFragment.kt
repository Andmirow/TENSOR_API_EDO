package com.example.tensor_api_edo.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tensor_api_edo.databinding.ListComandBinding
import com.example.tensor_api_edo.presentation.documents_view.DocumentsList

class ListComandFragment : Fragment() {

    lateinit var binding : ListComandBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ListComandBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.incoming.setOnClickListener {
            DocumentsList.newInstance("Входящие")
        }
        binding.outcoming.setOnClickListener {

        }

    }


    companion object {

        @JvmStatic
        fun newInstance() =
            ListComandFragment().apply {
                arguments = Bundle()
            }
    }
}