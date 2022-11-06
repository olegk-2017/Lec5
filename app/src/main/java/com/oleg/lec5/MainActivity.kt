package com.oleg.lec5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ACTION: SET_ALARM
        val intent = Intent(AlarmClock.ACTION_SET_ALARM)

        //Extras:
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Android Class")
        intent.putExtra(AlarmClock.EXTRA_HOUR, 17)
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 30)

        startActivity(intent)

    }
}