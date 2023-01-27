package com.example.vivo_app_call.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vivo_app_call.model.Call

@Dao
interface CallDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(call: Call)


    @Query("SELECT * FROM Call_Tables ORDER BY id ASC")
    fun readAllData() : LiveData<List<Call>>
}