package com.example.tensor_api_edo.presentation.documents_view.info_doc.recycler_view_tools

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.tensor_api_edo.databinding.FileNameCardBinding
import com.example.tensor_api_edo.domain.InnerFile


class DocumentInfoAdapter(private val onClickListener : ((InnerFile)-> Unit)) : ListAdapter<InnerFile, DocumentInfoViewHolder>(DocumentInfoDiffItemCallBack()) {

    private lateinit var binding : FileNameCardBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentInfoViewHolder {
        binding = FileNameCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        Log.i("MyResult","onCreateViewHolder")
        return DocumentInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocumentInfoViewHolder, position: Int) {
        val document = getItem(position)
        Log.i("MyResult",document.name)
        binding.tvNameFile.text = document.name

        binding.root.setOnClickListener {
            onClickListener(document)
        }
    }
}