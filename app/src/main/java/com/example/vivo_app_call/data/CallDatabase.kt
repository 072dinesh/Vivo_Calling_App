package com.example.vivo_app_call.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vivo_app_call.model.Call


@Database(entities = [Call::class],version=1)
abstract class CallDatabase: RoomDatabase() {

    abstract fun callDao() : CallDao

    companion object{

        private var INSTANCE: CallDatabase?=null
        fun getDatabase(context: Context): CallDatabase {

            if (INSTANCE==null)
            {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        CallDatabase::class.java,"call_database").build()

                }

            }
            return INSTANCE!!

        }

    }



}