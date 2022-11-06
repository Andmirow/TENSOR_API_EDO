package com.example.tensor_api_edo

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tensor_api_edo.data.ApiEdo
import com.example.tensor_api_edo.data.Authenticate.AnswerAuthenticate
import com.example.tensor_api_edo.data.Authenticate.qest.Params
import com.example.tensor_api_edo.data.Authenticate.qest.qestionAuthenticate
import com.example.tensor_api_edo.data.Authenticate.qest.Параметр
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(application : Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()


    private val _selected = MutableLiveData<AnswerAuthenticate>()
    val selected: LiveData<AnswerAuthenticate>
        get() = _selected


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchList(filmApi: ApiEdo?){
        Log.i("MyResult","fetchList")
        filmApi?.let { filmApi ->
            val disposable =filmApi.Authenticate(createParams())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    Log.e("TAG", it.result)
                    _selected.postValue(it)
                    Log.i("MyResult","good")
                },{

                    Log.i("MyResult",it.toString())
                })
        }

    }

    fun createParams(): qestionAuthenticate{
        val параметр = Параметр("AdminTest2","AdminTest2")
        val params = Params(параметр)
        val qest = qestionAuthenticate(params = params)
        Log.i("MyResult",qest.toString())
        return qest
    }







}