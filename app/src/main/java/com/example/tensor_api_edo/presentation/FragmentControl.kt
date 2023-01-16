package com.example.tensor_api_edo.presentation

import androidx.fragment.app.Fragment

interface FragmentControl {
    fun closeFragment()
    fun openNewFragment(fragment : Fragment)
    fun closeAndOpenNewFragment(fragment : Fragment)
}