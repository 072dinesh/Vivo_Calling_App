package com.example.vivo_app_call.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Call_Tables")
data class Call (
    @PrimaryKey(autoGenerate=true)
    val id : Int,
//    val img_user : Int,
    val customer_number : String,
    val customer_time : String,
   // val img_call : Int
): Parcelable