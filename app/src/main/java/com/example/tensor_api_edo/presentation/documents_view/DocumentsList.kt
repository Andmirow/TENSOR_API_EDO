package com.example.tensor_api_edo.presentation.documents_view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tensor_api_edo.databinding.ListDocumentsBinding
import com.example.tensor_api_edo.domain.Document
import com.example.tensor_api_edo.domain.MyApp
import com.example.tensor_api_edo.presentation.FragmentControl
import com.example.tensor_api_edo.presentation.documents_view.recycler_view_tools.DocumentAdapter


class DocumentsList : Fragment() {

    private lateinit var viewModel: DocumentListViewModel
    private lateinit var binding : ListDocumentsBinding
    private lateinit var typeDocument: String
    private lateinit var howToCloseFragment : FragmentControl
    private val args by navArgs<DocumentsListArgs>()

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
        viewModel = ViewModelProvider(this)[DocumentListViewModel::class.java]

        //val args = DocumentsListArgs.fromBundle(requireArguments())
        typeDocument = args.typeDocument


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ListDocumentsBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
    }


    fun setRecyclerView(){
        viewModel.getListDocument((activity?.application as MyApp).apiEdo,"",typeDocument!!)
        val recycler = binding.rvListDoc

        val adapter = DocumentAdapter(this::openDocunemt)
        recycler.adapter = adapter

        viewModel.selected.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun openDocunemt(document: Document){
        findNavController().navigate(DocumentsListDirections.actionDocumentsListToDocumentInfoFragment(document))
    }

    companion object {

        const val TYPE_DOCUMENT = "TYPE_DOCUMENT"

        @JvmStatic
        fun newInstance(typeDocument: String) =
            DocumentsList().apply {
                arguments = Bundle().apply {
                    putString(TYPE_DOCUMENT, typeDocument)
                }
            }
    }



}