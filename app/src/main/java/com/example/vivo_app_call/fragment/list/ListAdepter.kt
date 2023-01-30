package com.example.vivo_app_call.fragment.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vivo_app_call.databinding.ItemViewBinding

import com.example.vivo_app_call.fragment.calling.Calling_model
import com.example.vivo_app_call.model.Call
import com.example.vivo_app_call.utils.DiffUtilExt


class ListAdepter():RecyclerView.Adapter<ListAdepter.MyViewHolder>() {
     lateinit var viewModelCall: Calling_model
    private var callList= emptyList<Call>()
    //private var callList = listOf<Call>()

    class MyViewHolder(private val binding : ItemViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(
            currentItem: Call
//            onMainClick: (Call) -> Unit,
//            onAlbumClick: (Call) -> Unit
        ){
            binding.calllist = currentItem


        }
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder.from(parent)

    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //val currentItem = callList[position]
        val currentItem = callList.getOrNull(position)

        currentItem?.let {
            holder.bind(it)
        }



    }

    override fun getItemCount(): Int {
        return callList.size
    }

    fun setData(user:List<Call>){
//        this.callList= user
//        notifyDataSetChanged()

        val userDiffUtil = DiffUtilExt(callList, user)
        val userDiffUtilResult = DiffUtil.calculateDiff(userDiffUtil)
        callList = user
        userDiffUtilResult.dispatchUpdatesTo(this)

    }




}