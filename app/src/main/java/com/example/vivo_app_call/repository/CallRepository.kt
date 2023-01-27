package com.example.vivo_app_call.repository

import androidx.lifecycle.LiveData
import com.example.vivo_app_call.data.CallDao
import com.example.vivo_app_call.model.Call

class CallRepository(private val callDao: CallDao) {

    val readAllData : LiveData<List<Call>> = callDao.readAllData()

    suspend fun addCall(call: Call){
        callDao.addUser(call)
    }

}