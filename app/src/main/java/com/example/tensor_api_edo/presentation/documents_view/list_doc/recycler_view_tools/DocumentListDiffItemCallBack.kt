package com.example.tensor_api_edo.presentation.documents_view.list_doc.recycler_view_tools

import androidx.recyclerview.widget.DiffUtil
import com.example.tensor_api_edo.domain.model_bl.Document


class DocumentListDiffItemCallBack : DiffUtil.ItemCallback<Document>() {

    override fun areItemsTheSame(oldItem: Document, newItem: Document): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Document, newItem: Document): Boolean {
        return oldItem == newItem
    }
}