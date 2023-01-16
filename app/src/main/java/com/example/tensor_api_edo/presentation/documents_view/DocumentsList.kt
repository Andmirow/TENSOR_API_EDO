package com.example.tensor_api_edo.presentation.documents_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tensor_api_edo.R
import com.example.tensor_api_edo.databinding.AuthenticateFormBinding
import com.example.tensor_api_edo.databinding.ListDocumentsBinding
import com.example.tensor_api_edo.domain.MyApp
import com.example.tensor_api_edo.domain.SbisSetting
import com.example.tensor_api_edo.presentation.ListComandFragment
import com.example.tensor_api_edo.presentation.authenticate_view.AuthenticateFragment
import com.example.tensor_api_edo.presentation.documents_view.recycler_view_tools.FilmAdapter


private const val TYPE_DOCUMENT = "TYPE_DOCUMENT"



class DocumentsList : Fragment() {

    lateinit var binding : ListDocumentsBinding
    private var typeDocument: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        val recycler = binding.rvListDoc

        val adapter = FilmAdapter()
        recycler.adapter = adapter
        val dividerItemDecorationVERTICAL = DividerItemDecoration(recycler.context, GridLayoutManager.VERTICAL)
        val dividerItemDecorationHORIZONTAL = DividerItemDecoration(recycler.context, GridLayoutManager.HORIZONTAL)
        recycler.addItemDecoration(dividerItemDecorationVERTICAL)
        recycler.addItemDecoration(dividerItemDecorationHORIZONTAL)
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