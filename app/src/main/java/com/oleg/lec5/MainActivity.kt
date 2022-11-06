package com.oleg.lec5

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var btnAlarm:Button
    lateinit var btnWaze:Button
    lateinit var btnCall:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlarm = findViewById(R.id.btn_alarm)
        btnWaze = findViewById(R.id.btn_waze)
        btnCall = findViewById(R.id.btn_call)

//        btnAlarm.setOnClickListener{setAlarm()}
        btnAlarm.setOnClickListener(this::onClick)
        btnWaze.setOnClickListener(this::onClick)



    }

    private fun onClick(view:View) {
        if (view == btnAlarm) {

            try {
                //ACTION: SET_ALARM
                Intent(AlarmClock.ACTION_SET_ALARM).apply {
                    putExtra(AlarmClock.EXTRA_MESSAGE, "Android Class")
                    putExtra(AlarmClock.EXTRA_HOUR, 17)
                    putExtra(AlarmClock.EXTRA_MINUTES, 30)
                    startActivity(this)
                }
                //Extras:
//        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Android Class")
//        intent.putExtra(AlarmClock.EXTRA_HOUR, 17)
//        intent.putExtra(AlarmClock.EXTRA_MINUTES, 30)
//            startActivity(intent)
            } catch (e: java.lang.Exception) {
                //show a toast no alarm clock
                Toast.makeText(this, "No Alarm clock", Toast.LENGTH_SHORT).show()
            }
        }
        else if (view == btnWaze){
            try {
                // Launch Waze to look for Hawaii:
                val url = "https://waze.com/ul?q=Hawaii"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } catch (ex: ActivityNotFoundException) {
                // If Waze is not installed, open it in Google Play:
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.waze"))
                startActivity(intent)
            }
        }
    }
}