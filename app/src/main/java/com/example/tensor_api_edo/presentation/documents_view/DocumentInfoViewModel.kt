package com.example.tensor_api_edo.presentation.documents_view

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tensor_api_edo.data.ApiEdo
import com.example.tensor_api_edo.di.DaggerEdoComponent
import com.example.tensor_api_edo.domain.SbisSetting
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.File
import javax.inject.Inject


class DocumentInfoViewModel(application : Application) : AndroidViewModel(application) {


    @Inject
    lateinit var compositeDisposable : CompositeDisposable

    init {
        DaggerEdoComponent.builder().build().inject(this)
    }


    private val _selected = MutableLiveData<String>()
    val selected: LiveData<String>
        get() = _selected



    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun getFile(EdoApi: ApiEdo?, data : String){
        Log.i("MyResult",data)
        EdoApi?.let { EdoApi ->
            val disposable =EdoApi.getFile(data,SbisSetting.idSession)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.i("MyResult","it")

                    Log.i("MyResult",it.toString())

                    //_selected.postValue(it)
                },{
                    Log.i("MyResult","throwable")
                    Log.i("MyResult",it.toString())
                })
        }
    }



}