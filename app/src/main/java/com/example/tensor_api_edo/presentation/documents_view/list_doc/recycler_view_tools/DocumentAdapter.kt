package com.example.tensor_api_edo.presentation.documents_view.list_doc.recycler_view_tools

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.tensor_api_edo.databinding.DocumentCardBinding
import com.example.tensor_api_edo.domain.model_bl.Document


class DocumentAdapter(private val onClickListener : ((Document)-> Unit)) : ListAdapter<Document, DocumentViewHolder>(
    DocumentListDiffItemCallBack()
) {

    private lateinit var binding : DocumentCardBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        binding = DocumentCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return DocumentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        val document = getItem(position)
        binding.tvTitle.text = document.name
        binding.tvData.text = document.data
        binding.tvStatus.text = document.status
        binding.tvPartner.text = document.partner


        binding.root.setOnClickListener {
            Log.e("TAG", "НАЖАЛ")
            onClickListener(document)
        }



    }

}