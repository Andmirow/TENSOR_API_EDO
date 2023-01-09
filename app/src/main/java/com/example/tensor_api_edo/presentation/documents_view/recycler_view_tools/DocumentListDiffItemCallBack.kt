package com.example.tensor_api_edo.presentation.documents_view.recycler_view_tools

import androidx.recyclerview.widget.DiffUtil
import com.example.tensor_api_edo.data.document_model.Документ


class DocumentListDiffItemCallBack : DiffUtil.ItemCallback<Документ>() {

    override fun areItemsTheSame(oldItem: Документ, newItem: Документ): Boolean {
        return oldItem.Идентификатор == newItem.Идентификатор && oldItem.Название == newItem.Название
    }

    override fun areContentsTheSame(oldItem: Документ, newItem: Документ): Boolean {
        return oldItem == newItem
    }
}