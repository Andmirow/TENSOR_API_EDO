package com.example.tensor_api_edo.presentation.documents_view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tensor_api_edo.data.ApiEdo
import com.example.tensor_api_edo.databinding.ListDocumentsBinding
import com.example.tensor_api_edo.domain.Document
import com.example.tensor_api_edo.domain.MyApp
import com.example.tensor_api_edo.presentation.FragmentControl
import com.example.tensor_api_edo.presentation.authenticate_view.AuthenticateViewModel
import com.example.tensor_api_edo.presentation.documents_view.recycler_view_tools.DocumentAdapter




private const val TYPE_DOCUMENT = "TYPE_DOCUMENT"

class DocumentsList : Fragment() {

    private lateinit var viewModel: DocumentListViewModel
    lateinit var binding : ListDocumentsBinding
    private var typeDocument: String? = null
    private lateinit var howToCloseFragment : FragmentControl


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentControl) {
            howToCloseFragment = context
        } else {
            throw RuntimeException("Activity must implement OnEditingFinishedListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DocumentListViewModel::class.java]
        arguments?.let {
            typeDocument = it.getString(TYPE_DOCUMENT)
        }
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
        //howToCloseFragment.openNewFragment(DocumentInfoFragment.newInstance(document))
    }

    companion object {

        @JvmStatic
        fun newInstance(typeDocument: String) =
            DocumentsList().apply {
                arguments = Bundle().apply {
                    putString(TYPE_DOCUMENT, typeDocument)
                }
            }
    }



}