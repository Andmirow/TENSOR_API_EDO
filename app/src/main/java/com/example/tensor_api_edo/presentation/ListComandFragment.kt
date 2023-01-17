package com.example.tensor_api_edo.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tensor_api_edo.databinding.ListComandBinding
import com.example.tensor_api_edo.presentation.documents_view.DocumentsList

class ListComandFragment : Fragment() {

    lateinit var binding : ListComandBinding
    private lateinit var howToCloseFragment : FragmentControl

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentControl) {
            howToCloseFragment = context
        } else {
            throw RuntimeException("Activity must implement OnEditingFinishedListener")
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ListComandBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.incoming.setOnClickListener {
            howToCloseFragment.openNewFragment(DocumentsList.newInstance("Входящие"))
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