package com.example.tensor_api_edo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tensor_api_edo.R
import com.example.tensor_api_edo.databinding.ActivityMainBinding
import com.example.tensor_api_edo.domain.SbisSetting

class MainActivity : AppCompatActivity(),HowToCloseFragment {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (SbisSetting.idSession == ""){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, AuthenticateFragment::class.java, null)
                .commit()
        }else{
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, ListComand::class.java, null)
                .commit()
        }




//        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel.fetchList((this.application as FilmApp).apiEdo)


    }

    override fun closeFragment() {
        supportFragmentManager.popBackStack()
    }
}