package com.example.vivo_app_call.fragment.calling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Calling_modelsecond(private val findnumber:String):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(Calling_model::class.java)){
            return Calling_model(findnumber) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}