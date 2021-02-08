package com.example.myapplication1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplication1.R

class ClicksEventsActivity : AppCompatActivity(), View.OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clicks_events)

        clickInLine()
        val btnMulti1 = findViewById<Button>(R.id.btnClickMulti1)
        val btnMulti2 = findViewById<Button>(R.id.btnClickMulti2)
        val btnMulti3 = findViewById<Button>(R.id.btnClickMulti3)

        btnMulti1.setOnLongClickListener(this)
        btnMulti2.setOnLongClickListener(this)
        btnMulti3.setOnLongClickListener(this)
    }

    fun xmlClick(view: View){
        Toast.makeText(this, "Click XML!", Toast.LENGTH_LONG).show()
    }

    fun clickInLine(){
        val btnInLine = findViewById<Button>(R.id.btnClickInLine)
        btnInLine.setOnClickListener{ Toast.makeText(this, "Click in Line!", Toast.LENGTH_LONG).show() }
    }

    override fun onLongClick(v: View): Boolean {
        when(v.id){
            R.id.btnClickMulti1 -> Toast.makeText(this, "Click Multi 1!", Toast.LENGTH_LONG).show()
            R.id.btnClickMulti2 -> Toast.makeText(this, "Click Multi 2!", Toast.LENGTH_LONG).show()
            R.id.btnClickMulti3 -> Toast.makeText(this, "Click Multi 3!", Toast.LENGTH_LONG).show()
        }
        return true
    }
}