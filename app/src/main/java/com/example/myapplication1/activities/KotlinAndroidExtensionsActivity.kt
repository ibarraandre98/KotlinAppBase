package com.example.myapplication1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        val btn = findViewById<Button>(R.id.btnById)
        btn.setOnClickListener { Toast.makeText(this, "Click by ID", Toast.LENGTH_SHORT).show() }


        btnByKAT.setOnClickListener { Toast.makeText(this, "Click by KAT", Toast.LENGTH_SHORT).show() }
    }


}