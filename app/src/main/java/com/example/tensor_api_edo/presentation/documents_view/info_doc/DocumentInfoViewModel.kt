package com.example.tensor_api_edo.presentation.documents_view.info_doc

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tensor_api_edo.data.ApiEdo
import com.example.tensor_api_edo.di.DaggerEdoComponent
import com.example.tensor_api_edo.domain.model_bl.Attachment
import com.example.tensor_api_edo.domain.SbisSetting
import io.reactivex.disposables.CompositeDisposable
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


    private val _isSuccess = MutableLiveData<MutableList<Attachment>>()
    val isSuccess: LiveData<MutableList<Attachment>>
        get() = _isSuccess



    fun getHtml(edoApi: ApiEdo, attachments: MutableList<Attachment>){
        for (i in attachments){
            if (i.isFormalized){
                val res = i.linckOfHtml?.let { edoApi.getFile(it,SbisSetting.idSession) }
                res?.enqueue(object : retrofit2.Callback<ResponseBody> {
                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                        val arrayBytes = response.body()?.bytes()


                        val attachment = i.copy(html = arrayBytes)
                        Log.i("MyResult",attachment.toString())
                        var mutList = _isSuccess.value
                        if(mutList ==null){
                            mutList = mutableListOf()
                        }
                        mutList.add(attachment)
                        mutList.let {
                            _isSuccess.value = it
                            Log.i("MyResult","let")
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Log.i("MyResult",t.toString())
                    }

                })
            }else{

            }



        }
    }

}