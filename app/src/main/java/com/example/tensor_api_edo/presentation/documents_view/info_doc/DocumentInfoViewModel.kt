package com.example.tensor_api_edo.presentation.documents_view.info_doc

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tensor_api_edo.data.ApiEdo
import com.example.tensor_api_edo.di.DaggerEdoComponent
import com.example.tensor_api_edo.domain.InnerFile
import com.example.tensor_api_edo.domain.SbisSetting
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class DocumentInfoViewModel(application : Application) : AndroidViewModel(application) {


    @Inject
    lateinit var compositeDisposable : CompositeDisposable

    init {
        DaggerEdoComponent.builder().build().inject(this)
    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }




//    private val _isSuccess = MutableLiveData<ByteArray>()
//    val isSuccess: LiveData<ByteArray>
//        get() = _isSuccess

    private val _isSuccess = MutableLiveData<InnerFile>()
    val isSuccess: LiveData<InnerFile>
        get() = _isSuccess


    fun getHtml(edoApi: ApiEdo, html_lincks: MutableMap<String,String>){


        for (i in html_lincks){
            val res = edoApi.getFile(i.value,SbisSetting.idSession)
            res.enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    val arrayBytes = response.body()?.bytes()
                    val innerFile = InnerFile(i.key,arrayBytes)
//                    val myString = String(arrayBytes)
//                    Log.i("MyResult",myString)
                    Log.i("MyResult",innerFile.toString())
                    _isSuccess.value = innerFile

//                    _isSuccess.value?.add(innerFile)
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.i("MyResult",t.toString())
                }
            })
        }






//        EdoApi?.let { EdoApi ->
//            val disposable =EdoApi.getDocumentListForEvent(createParams(data,RegistryType), SbisSetting.idSession)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    Log.i("Result1",it.toString())
//                    val res = it.result.Реестр
//                    val listDoc = MapperDocuments.getListDocumentFromReestr(res)
//                    _selected.postValue(listDoc)
//                },{
//                    Log.i("MyResult",it.toString())
//                })
//        }






    }



}