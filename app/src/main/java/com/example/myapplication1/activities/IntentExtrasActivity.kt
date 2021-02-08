package com.example.myapplication1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.myapplication1.R
import com.example.myapplication1.models.Student
import com.example.myapplication1.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : ToolbarActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        btnGoBack.setOnClickListener { startActivity(Intent(this, IntentsActivity:: class.java)) }

        getIntentExtrasFromPreviousActivity()
        getIntentObject()
    }

    private fun getIntentExtrasFromPreviousActivity(){
        val name:String? = intent.getStringExtra("name")
        val lastName:String? = intent.getStringExtra("lastName")
        val age:Int = intent.getIntExtra("age", -1)
        val developer = intent.getBooleanExtra( "developer", false)

        if(name != null && lastName != null && age >= 0){
            textViewName.text = name
            textViewLastName.text = lastName
            textViewAge.text = "$age"
            checkBoxDeveloper.isChecked = developer
            checkBoxDeveloper.text = "Developer"
        }
    }

    private fun getIntentObject(){
        val student = intent.getParcelableExtra<Student>("student")

        if(student != null){
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = "${student.age}"
            checkBoxDeveloper.isChecked = student.isDeveloper
            checkBoxDeveloper.text = "Developer"
        }
    }

}