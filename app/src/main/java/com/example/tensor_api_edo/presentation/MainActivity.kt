package com.example.tensor_api_edo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tensor_api_edo.R
import com.example.tensor_api_edo.databinding.ActivityMainBinding
import com.example.tensor_api_edo.domain.SbisSetting
import com.example.tensor_api_edo.presentation.authenticate_view.AuthenticateFragment
import com.example.tensor_api_edo.presentation.authenticate_view.AuthenticateViewModel

class MainActivity : AppCompatActivity(), FragmentControl {


    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun openNewFragment(fragment : Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun closeAndOpenNewFragment(fragment : Fragment){
        closeFragment()
        openNewFragment(fragment)
    }

    override fun closeFragment() {
        supportFragmentManager.popBackStack()
    }
}