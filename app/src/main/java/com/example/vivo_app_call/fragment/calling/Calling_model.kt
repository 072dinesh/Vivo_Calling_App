package com.example.vivo_app_call.fragment.calling

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.concurrent.TimeUnit

class Calling_model(findnumber:String) :ViewModel() {
    private var _cunumber = MutableLiveData<String>()
    val score: LiveData<String>
    get() = _cunumber

     var endtime = MutableLiveData<String>()


    init {
        _cunumber.value = findnumber
    }









}