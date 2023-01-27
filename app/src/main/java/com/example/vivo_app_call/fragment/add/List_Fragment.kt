package com.example.vivo_app_call.fragment.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vivo_app_call.R
import com.example.vivo_app_call.databinding.FragmentListBinding
import com.example.vivo_app_call.viewmodel.CallViewModel
import kotlinx.android.synthetic.main.fragment_list_.view.*

class List_Fragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private lateinit var mUserViewModel: CallViewModel
    val adapter = Adepter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentListBinding.inflate(LayoutInflater.from(context))

        var view = binding.root

        val recyclerView=view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this).get(CallViewModel::class.java)
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