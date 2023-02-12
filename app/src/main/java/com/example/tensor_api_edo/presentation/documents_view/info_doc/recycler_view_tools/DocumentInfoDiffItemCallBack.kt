package com.example.tensor_api_edo.presentation.documents_view.info_doc.recycler_view_tools

import androidx.recyclerview.widget.DiffUtil
import com.example.tensor_api_edo.domain.model_bl.Attachment


class DocumentInfoDiffItemCallBack : DiffUtil.ItemCallback<Attachment>() {

    override fun areItemsTheSame(oldItem: Attachment, newItem: Attachment): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Attachment, newItem: Attachment): Boolean {
        return oldItem == newItem
    }
}