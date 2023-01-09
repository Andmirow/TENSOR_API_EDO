package com.example.tensor_api_edo.presentation.documents_view.recycler_view_tools

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.tensor_api_edo.data.document_model.Документ
import com.example.tensor_api_edo.databinding.DocumentCardBinding


class FilmAdapter() : ListAdapter<Документ, DocumentViewHolder>(DocumentListDiffItemCallBack()) {

    lateinit var binding : DocumentCardBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        binding = DocumentCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DocumentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {

    }
}