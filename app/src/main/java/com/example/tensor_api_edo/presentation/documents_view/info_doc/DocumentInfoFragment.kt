package com.example.tensor_api_edo.presentation.documents_view.info_doc

import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.tensor_api_edo.databinding.DocumentInfoBinding
import com.example.tensor_api_edo.domain.model_bl.Document
import com.example.tensor_api_edo.domain.model_bl.Attachment
import com.example.tensor_api_edo.domain.MyApp
import com.example.tensor_api_edo.presentation.documents_view.info_doc.recycler_view_tools.DocumentInfoAdapter


class DocumentInfoFragment : Fragment() {

    private lateinit var document : Document
    private val args by navArgs<DocumentInfoFragmentArgs>()
    private lateinit var binding : DocumentInfoBinding
    private lateinit var viewModel: DocumentInfoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        document = args.document
        viewModel = ViewModelProvider(this)[DocumentInfoViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DocumentInfoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("MyResult","start")
        viewModel.getHtml((activity?.application as MyApp).apiEdo,document.attachments)


        viewModel.isSuccess.observe(viewLifecycleOwner) {
            Log.i("MyResult","isSuccess")
            setWebView(it[0])
            document.attachments = it
            setRecyclerView()
        }

    }

    private fun setRecyclerView(){
        Log.i("MyResult","setRecyclerView")
        val recycler = binding.rvDocList
        val adapter = DocumentInfoAdapter(this::setWebView)
        recycler.adapter = adapter
        Log.i("MyResult",document.attachments.toString())
        val list = document.attachments as List<Attachment>
        adapter.submitList(list)
        Log.i("MyResult",document.attachments.size.toString())
    }



    private fun setWebView(file: Attachment){
        if (file.html!=null){
            Log.i("MyResult",file.toString())
            val encodedHtml: String = Base64.encodeToString(file.html, Base64.NO_PADDING)
            binding.webViewDoc
            binding.webViewDoc.loadData(encodedHtml, "text/html", "base64")
            binding.webViewDoc.settings.javaScriptEnabled = true
            binding.webViewDoc.settings.setSupportZoom(true)
            binding.webViewDoc.settings.builtInZoomControls = true
            binding.webViewDoc.setPadding(0, 0, 0, 0)
        }
    }
}