package com.example.myapplication1.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.myapplication1.R
import com.example.myapplication1.others.LifeCycleEventsActivity

class LifeCycleActivity : LifeCycleEventsActivity() {

    private var exitEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onBackPressed() {
        if(exitEnabled) super.onBackPressed()
        exitEnabled = true
        Toast.makeText(this, "Click again to exit", Toast.LENGTH_LONG).show()
        Handler().postDelayed(Runnable { exitEnabled = false }, 2000)
    }
}