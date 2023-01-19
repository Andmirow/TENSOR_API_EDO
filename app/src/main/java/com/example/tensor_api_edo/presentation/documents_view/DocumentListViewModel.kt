package com.example.tensor_api_edo.presentation.documents_view

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tensor_api_edo.data.ApiEdo
import com.example.tensor_api_edo.data.FilterModel
import com.example.tensor_api_edo.data.TensorQuery
import com.example.tensor_api_edo.data.document_model.Result
import com.example.tensor_api_edo.data.document_model.Реестр
import com.example.tensor_api_edo.data.document_model.Фильтр
import com.example.tensor_api_edo.di.DaggerEdoComponent
import com.example.tensor_api_edo.domain.Document
import com.example.tensor_api_edo.domain.MapperDocuments
import com.example.tensor_api_edo.domain.SbisSetting
import com.google.gson.internal.LinkedTreeMap
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DocumentListViewModel(application : Application) : AndroidViewModel(application) {


    @Inject
    lateinit var compositeDisposable : CompositeDisposable

    init {
        DaggerEdoComponent.builder().build().inject(this)
    }


    private val _selected = MutableLiveData<List<Document>>()
    val selected: LiveData<List<Document>>
        get() = _selected



    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun getListDocument(EdoApi: ApiEdo?, data : String, RegistryType : String){
        EdoApi?.let { EdoApi ->
            val disposable =EdoApi.getDocumentListForEvent(createParams(data,RegistryType), SbisSetting.idSession)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.i("Result1",it.toString())
                    val res = it.result.Реестр
                    val listDoc = MapperDocuments.getListDocumentFromReestr(res)
                    _selected.postValue(listDoc)
                },{
                    Log.i("MyResult",it.toString())
                })
        }
    }

    private fun createParams(data : String, RegistryType : String): TensorQuery {
        return TensorQuery(method = "СБИС.СписокДокументовПоСобытиям", params = FilterModel(Фильтр = Фильтр(data,RegistryType)))
    }



}