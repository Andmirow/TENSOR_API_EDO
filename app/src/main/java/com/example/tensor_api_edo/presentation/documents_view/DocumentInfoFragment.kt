package com.example.tensor_api_edo.presentation.documents_view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tensor_api_edo.domain.Document
import com.example.tensor_api_edo.presentation.FragmentControl

private const val DOCUMENT = "DOCUMENT"

class DocumentInfoFragment : Fragment() {

    private var document : Document? = null
    private var howToCloseFragment : FragmentControl? = null

    companion object {

        @JvmStatic
        fun newInstance(document : Document) =
            DocumentsList().apply {
                arguments = Bundle().apply {
                    putParcelable(DOCUMENT, document)
                }
            }
    }

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
        arguments?.let {
            document = it.getParcelable(DOCUMENT)!!
        }
    }


}