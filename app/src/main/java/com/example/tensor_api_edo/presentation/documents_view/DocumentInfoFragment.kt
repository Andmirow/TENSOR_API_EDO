package com.example.tensor_api_edo.presentation.documents_view

import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.tensor_api_edo.databinding.DocumentInfoBinding
import com.example.tensor_api_edo.domain.Document
import com.example.tensor_api_edo.domain.MyApp


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
        viewModel.getHtml((activity?.application as MyApp).apiEdo,document.HTML)


        viewModel.isSuccess.observe(viewLifecycleOwner) {
            val encodedHtml: String = Base64.encodeToString(it, Base64.NO_PADDING)
            binding.webViewDoc

            binding.webViewDoc.loadData(encodedHtml, "text/html", "base64")

            binding.webViewDoc.settings.javaScriptEnabled = true

            binding.webViewDoc.settings.setSupportZoom(true)
            binding.webViewDoc.settings.builtInZoomControls = true
            binding.webViewDoc.setPadding(0, 0, 0, 0)
            //webView.loadData(it,null,"windows-1251")




        }



//        viewModel.selected.observe(viewLifecycleOwner) {
//            Glide.with(binding.imageView.context)
//                .load(it)
//                .fitCenter()
//                .into(binding.imageView)
//
//        }





    }


}