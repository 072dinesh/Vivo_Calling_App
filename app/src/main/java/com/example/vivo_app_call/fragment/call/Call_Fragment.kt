package com.example.vivo_app_call.fragment.call

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.vivo_app_call.R
import com.example.vivo_app_call.databinding.FragmentCallBinding
import kotlinx.android.synthetic.main.fragment_call_.*

class Call_Fragment : Fragment() {

    lateinit var binding: FragmentCallBinding
    var digit_on_screen = StringBuilder()

    lateinit var callview : Call_model_view


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        callview = ViewModelProvider(this).get(Call_model_view::class.java)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_call_,
            container,
            false
        )

        binding.calldata = callview
        binding.lifecycleOwner = viewLifecycleOwner

            binding.call.setOnClickListener{

//                findNavController().navigate(R.id.action_call_Fragment_to_calling_Fragment)

                var action = Call_FragmentDirections.actionCallFragmentToCallingFragment(callview.numbersAll.value.toString())
                findNavController().navigate(action)

            }



       insertDataToDatabasde()
//        funtion_cln()
        return binding.root
    }
//    private fun updateScoreText() {
//        binding.scoreText.text = viewModel.score.value.toString()
//    }







    fun insertDataToDatabasde() {

//            binding.resultId.text = callview.numbersAll.value.toString()

//        binding.oneBtn.setOnClickListener {
//            appendToDigitOnScreen("1")
//        }
//
//        binding.twoBtn.setOnClickListener {
//            appendToDigitOnScreen("2")
//        }
//
//        binding.threeBtn.setOnClickListener {
//            appendToDigitOnScreen("3")
//        }
//
//        binding.fourBtn.setOnClickListener {
//            appendToDigitOnScreen("4")
//        }
//
//        binding.fiveBtn.setOnClickListener {
//            appendToDigitOnScreen("5")
//        }
//
//        binding.sixBtn.setOnClickListener {
//            appendToDigitOnScreen("6")
//        }
//
//        binding.sevenBtn.setOnClickListener {
//            appendToDigitOnScreen("7")
//        }
//
//        binding.egtBtn.setOnClickListener {
//            appendToDigitOnScreen("8")
//        }
//
//        binding.nigBtn.setOnClickListener {
//            appendToDigitOnScreen("9")
//        }
//
//        binding.zeroBtn.setOnClickListener {
//            appendToDigitOnScreen("0")
//        }
//
//        binding.hesBtn.setOnClickListener {
//            appendToDigitOnScreen("#")
//        }







    }
    private fun inputChek(one:Button,two:Button,three:Button,four:Button,five:Button,six:Button,seven:Button,egt:Button,nig:Button,zero:Button,heshh:Button):Boolean{

        return !(one.isClickable && two.isClickable && three.isClickable && four.isClickable && five.isClickable && six.isClickable && seven.isClickable && egt.isClickable && nig.isClickable && zero.isClickable && heshh.isClickable)

    }

    private fun clearDigit() {

        val length = digit_on_screen.length

        digit_on_screen.deleteCharAt(length - 1)
        result_id.text = digit_on_screen.toString()

    }

    private  fun funtion_cln(){

        binding.cancle.setOnClickListener {

            if (digit_on_screen.length <= 0) {
                return@setOnClickListener
            }else{
                clearDigit()
            }
        }

    }




}