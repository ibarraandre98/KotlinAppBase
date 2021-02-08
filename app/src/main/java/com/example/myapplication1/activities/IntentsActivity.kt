package com.example.myapplication1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication1.R
import com.example.myapplication1.models.Student
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        buttonIntentExtras.setOnClickListener{ goIntentExtras() }
        buttonIntentFlags.setOnClickListener{ goIntentFlags() }
        buttonIntentObject.setOnClickListener{ goIntentObjects() }
    }

    private fun goIntentExtras(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name", "André")
        intent.putExtra("lastName", "Ibarra")
        intent.putExtra("age", 22)
        intent.putExtra("developer", true)
        startActivity(intent)
    }

    private fun goIntentFlags(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun goIntentObjects(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Brian", "Ibarra", 16, false)
        intent.putExtra("student", student)
        startActivity(intent)
    }
}