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
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import java.io.File
import javax.inject.Inject


class DocumentInfoViewModel(application : Application) : AndroidViewModel(application) {


    private val _isSuccess = MutableLiveData<ByteArray>()
    val isSuccess: LiveData<ByteArray>
        get() = _isSuccess


    fun getHtml(edoApi: ApiEdo, html_linck: String){
        val res = edoApi.getFile(html_linck,SbisSetting.idSession)
        res.enqueue(object : retrofit2.Callback<ResponseBody> {

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val arrayBytes = response.body()!!.bytes()
                val myString = String(arrayBytes)
                Log.i("MyResult",myString)
                _isSuccess.value = arrayBytes

            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.i("MyResult",t.toString())
            }

        })

    }



}