package com.example.tensor_api_edo.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tensor_api_edo.data.ApiEdo
import com.example.tensor_api_edo.data.Authenticate.qest.AuthenticateParams
import com.example.tensor_api_edo.data.Authenticate.qest.Параметр
import com.example.tensor_api_edo.data.TensorQuery
import com.example.tensor_api_edo.domain.SbisSetting
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AuthenticateViewModel(application : Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean>
        get() = _isSuccess


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    fun authenticate(EdoApi: ApiEdo?,login : String, password : String){
        Log.i("MyResult","fetchList")
        EdoApi?.let { EdoApi ->
            val disposable =EdoApi.Authenticate(createParams(login,password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    SbisSetting.idSession = it.result
                    Log.e("TAG", it.result)
                    _isSuccess.postValue(true)
                },{
                    _isSuccess.postValue(false)
                    Log.i("MyResult",it.toString())
                })
        }

    }

    fun createParams(login : String, password : String): TensorQuery {

        return TensorQuery(method = "СБИС.Аутентифицировать", params = AuthenticateParams(Параметр(login,password)))
    }







}