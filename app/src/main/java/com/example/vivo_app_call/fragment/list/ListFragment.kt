package com.example.vivo_app_call.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vivo_app_call.R
import com.example.vivo_app_call.databinding.FragmentListBinding
import com.example.vivo_app_call.viewmodel.CallViewModel
import kotlinx.android.synthetic.main.fragment_list_.view.*

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private val mUserViewModel: CallViewModel by viewModels()



    //private val viewmodel: CallViewModel by viewModels()

    val adapter = ListAdepter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //binding=FragmentListBinding.inflate(LayoutInflater.from(context))

        binding = FragmentListBinding.inflate(inflater, container, false)


        var view = binding.root

        val recyclerView=view.recyclerview

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
       // mUserViewModel = ViewModelProvider(this).get(CallViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {
                user ->
            adapter.setData(user)
        })
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_list_Fragment_to_call_Fragment)

        }
        setHasOptionsMenu(true)
        return  view
    }


}