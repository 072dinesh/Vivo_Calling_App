package com.example.vivo_app_call.fragment.calling

import android.content.Intent
import android.os.IBinder
import java.util.Timer
import java.util.TimerTask

class TimeService : android.app.Service() {
    override fun onBind(intent: Intent?): IBinder?=null

    private  val times =Timer()


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val time = intent?.getDoubleExtra(TIME_EXTRA,0.0)
        times.scheduleAtFixedRate(time?.let { TimeTask(it) },0,1000)

        return START_NOT_STICKY

    }

    override fun onDestroy() {
        times.cancel()
        super.onDestroy()
    }

    private inner class TimeTask(private var time:Double):TimerTask(){
        override fun run() {
            val intent = Intent(TIME_UPDATE)
            time++
            intent.putExtra(TIME_EXTRA,time)
              sendBroadcast(intent)

        }

    }

    companion object{

        const val TIME_UPDATE = "timerUpted"
        const val TIME_EXTRA  = "timeExtra"
    }




}