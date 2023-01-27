package com.example.vivo_app_call.fragment.add

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vivo_app_call.R
import com.example.vivo_app_call.fragment.calling.Calling_model
import com.example.vivo_app_call.model.Call
import kotlinx.android.synthetic.main.item_view.view.*



class Adepter():RecyclerView.Adapter<Adepter.MyViewHolder>() {
     lateinit var viewModelCall: Calling_model
    private var callList= emptyList<Call>()
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))


    }





    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = callList[position]


        holder.itemView.name.text = currentItem.customer_number
        holder.itemView.timess.text = currentItem.customer_time


    }

    override fun getItemCount(): Int {
        return callList.size
    }

    fun setData(user:List<Call>){
        this.callList= user
        notifyDataSetChanged()
    }

}