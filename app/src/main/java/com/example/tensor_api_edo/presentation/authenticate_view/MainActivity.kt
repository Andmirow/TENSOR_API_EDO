package com.example.tensor_api_edo.presentation.authenticate_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tensor_api_edo.databinding.ActivityMainBinding
import com.example.tensor_api_edo.domain.FilmApp
import com.example.tensor_api_edo.domain.test.SimpleModel
import com.example.tensor_api_edo.presentation.HowToCloseFragment
import com.example.tensor_api_edo.presentation.ListComand
import com.stanfy.gsonxml.GsonXmlBuilder
import com.stanfy.gsonxml.XmlParserCreator
import org.xmlpull.v1.XmlPullParserFactory

class MainActivity : AppCompatActivity(), HowToCloseFragment {

    private lateinit var viewModel: AuthenticateViewModel
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(AuthenticateViewModel::class.java)

        //
//        val parserCreator = XmlParserCreator { XmlPullParserFactory.newInstance().newPullParser() }
//        val gsonXml = GsonXmlBuilder().setXmlParserCreator(parserCreator).create()
//        val xml = "<model><name>my name</name><description>my description</description></model>"
//        val model = gsonXml.fromXml(xml, SimpleModel::class.java)
//        Log.e("xml",   model.toString())
        //

        binding.btAuthenticate.setOnClickListener {
            var login = binding.etLogin.editText?.text.toString()
            var password = binding.etPassword.editText?.text.toString()
            viewModel.authenticate((this.application as FilmApp).apiEdo,login,password)
        }

        viewModel.isSuccess.observe(this) {
            if (it) {
                val intent = ListComand.newList(this)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext, "неправильные параметры авторизации", Toast.LENGTH_LONG).show()
            }
        }

//        if (SbisSetting.idSession == ""){
//            supportFragmentManager
//                .beginTransaction()
//                .addToBackStack(null)
//                .add(R.id.fragment_container_view, AuthenticateFragment::class.java, null)
//                .commit()
//        }else{
//            supportFragmentManager
//                .beginTransaction()
//                .addToBackStack(null)
//                .add(R.id.fragment_container_view, ListComand::class.java, null)
//                .commit()
//        }




//        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel.fetchList((this.application as FilmApp).apiEdo)


    }

    override fun closeFragment() {
        supportFragmentManager.popBackStack()
    }
}