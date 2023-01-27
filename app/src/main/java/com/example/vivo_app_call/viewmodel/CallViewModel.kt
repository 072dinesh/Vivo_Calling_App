package com.example.vivo_app_call.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.vivo_app_call.data.CallDatabase
import com.example.vivo_app_call.model.Call
import com.example.vivo_app_call.repository.CallRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CallViewModel (application: Application) : AndroidViewModel(application){

    val readAllData : LiveData<List<Call>>


    private val repository: CallRepository

    init {
        val callDao = CallDatabase.getDatabase(application).callDao()
        repository = CallRepository(callDao)
        readAllData = repository.readAllData
    }
    fun addCall(call: Call){
        viewModelScope.launch(Dispatchers.IO){
            repository.addCall(call)
        }
    }



}