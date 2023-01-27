package com.example.vivo_app_call.fragment.call


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.fragment_call_.*
import net.objecthunter.exp4j.Expression


class Call_model_view : ViewModel() {

    var digit_on_screen = StringBuilder()
   val numbersAll = MutableLiveData<String>()
    private val _eventCall = MutableLiveData<Boolean>()


    fun btnNumber(digit: String)  {
            appendToDigitOnScreen(digit)


        }


    private fun appendToDigitOnScreen(digit: String) {

        // Add each digit to our string builder
        digit_on_screen.append(digit)

        // display it on the screen of our mobile app
        numbersAll.value= digit_on_screen.toString()
    }


    fun clearDigitone(){
        val length = digit_on_screen.length
        digit_on_screen.deleteCharAt(length-1)
        numbersAll.value = digit_on_screen.toString()

    }




     fun clearDigit() :Boolean{

         val length = digit_on_screen.length

         if(length==0) {

         } else {
             digit_on_screen.delete(0,length)
             numbersAll.value = digit_on_screen.toString()


         }
        return true


    }








//    var operation: Char = ' '
//    var leftHandSide: Double = 0.0
//    fun selectOperation(c: Char) {
//
//        operation = c
//        leftHandSide = digit_on_screen.toString().toDouble()
//        digit_on_screen.clear()
//        numbersAll.value = "0"
//    }



    fun floatincall() {
        _eventCall.value = true
    }

}