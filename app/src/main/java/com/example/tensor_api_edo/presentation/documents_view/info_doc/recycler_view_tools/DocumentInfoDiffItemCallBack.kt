package com.example.tensor_api_edo.presentation.documents_view.info_doc.recycler_view_tools

import androidx.recyclerview.widget.DiffUtil
import com.example.tensor_api_edo.domain.Document
import com.example.tensor_api_edo.domain.InnerFile


class DocumentInfoDiffItemCallBack : DiffUtil.ItemCallback<InnerFile>() {

    override fun areItemsTheSame(oldItem: InnerFile, newItem: InnerFile): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: InnerFile, newItem: InnerFile): Boolean {
        return oldItem == newItem
    }
}