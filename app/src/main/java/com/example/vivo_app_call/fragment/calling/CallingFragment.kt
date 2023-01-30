package com.example.vivo_app_call.fragment.calling

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.vivo_app_call.R
import com.example.vivo_app_call.databinding.FragmentCallingBinding
import com.example.vivo_app_call.model.Call
import com.example.vivo_app_call.viewmodel.CallViewModel
import kotlinx.android.synthetic.main.fragment_calling_.*


class CallingFragment : Fragment() {


    lateinit var binding: FragmentCallingBinding

    private val viewModelCall: Calling_model by viewModels{viewModelCallSecon}
//    private lateinit var viewmodel :CallViewModel
    private val viewmodel: CallViewModel by viewModels()
    private lateinit var viewModelCallSecon: Calling_modelsecond

    private var timeStarted = false
    private lateinit var serviceIntent : Intent
    private var time = 0.0


    var input:String?=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding:FragmentCallingBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_calling_,
            container,
            false
        )


          viewModelCallSecon = Calling_modelsecond(CallingFragmentArgs.fromBundle(requireArguments()).score)
        //viewModelCall = ViewModelProvider(this, viewModelCallSecon).get(Calling_model::class.java)
        binding.callingdata = viewModelCall
        binding.lifecycleOwner = viewLifecycleOwner

         binding.timercall.start()


        binding.endcall.setOnClickListener {


            viewModelCall.endtime.value="Endcall"
                Handler().postDelayed({


                    findNavController().navigate(R.id.action_calling_Fragment_to_list_Fragment)

                }, 3000)

                binding.timercall.stop()
                var sarves = binding.timercall.text.toString()

                // Log.d("main", binding.timercall.text.toString())
                val call = Call(0, viewModelCall.score.value.toString(), sarves)



            viewmodel.addCall(call)
                Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

                //calculateTime(serviceLong.toLong())
            }




        return binding.root
    }







}