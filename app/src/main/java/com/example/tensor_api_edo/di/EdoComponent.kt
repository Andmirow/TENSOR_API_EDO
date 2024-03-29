package com.example.tensor_api_edo.di


import com.example.tensor_api_edo.domain.MyApp
import com.example.tensor_api_edo.presentation.authenticate_view.AuthenticateViewModel
import com.example.tensor_api_edo.presentation.documents_view.info_doc.DocumentInfoViewModel
import com.example.tensor_api_edo.presentation.documents_view.list_doc.DocumentListViewModel
import dagger.Component


@Component(modules = [RetrofitModule::class ])
interface EdoComponent {

    fun inject(activity: MyApp)

    fun inject(viewModel: AuthenticateViewModel)

    fun inject(viewModel: DocumentListViewModel)

    fun inject(viewModel: DocumentInfoViewModel)

}