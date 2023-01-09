package com.example.tensor_api_edo.presentation.documents_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesholder.presentation.recycler_view_tools.FilmAdapter
import com.example.tensor_api_edo.databinding.ListDocumentsBinding
import com.example.tensor_api_edo.presentation.documents_view.recycler_view_tools.FilmAdapter

class DocumentsList : AppCompatActivity() {

    lateinit var binding : ListDocumentsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }





    fun setRecyclerView(){
        val recycler = binding.rvListDoc

        val adapter = FilmAdapter()
        recycler.adapter = adapter
        val dividerItemDecorationVERTICAL = DividerItemDecoration(recycler.context, GridLayoutManager.VERTICAL)
        val dividerItemDecorationHORIZONTAL = DividerItemDecoration(recycler.context, GridLayoutManager.HORIZONTAL)
        recycler.addItemDecoration(dividerItemDecorationVERTICAL)
        recycler.addItemDecoration(dividerItemDecorationHORIZONTAL)

        viewModel.selected.observe(viewLifecycleOwner) {
            adapter.submitList(it.docs)
        }
    }



}