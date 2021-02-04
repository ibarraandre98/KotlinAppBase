package com.example.myapplication1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplication1.activities.LifeCycleActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLifeCycle = findViewById<Button>(R.id.button_to_cycle)
        val btnClickEvents = findViewById<Button>(R.id.button_to_click)
        val btnAndroidExt = findViewById<Button>(R.id.button_to_extensions)
        //val btnPicasso = findViewById<Button>(R.id.button_to_picasso)
        val btnListView = findViewById<Button>(R.id.button_to_list_view)
        val btnIntents = findViewById<Button>(R.id.button_to_intents)
        val btnPermission = findViewById<Button>(R.id.button_to_permissions)
        val btnSharedPreferences = findViewById<Button>(R.id.button_to_shared_preferences)
        val btnExtensionFunctions = findViewById<Button>(R.id.button_to_extensions_functions)



        showToast()
        showSnackBar()

    }

    private fun goToLifeCycleActivity(){
        val intent = Intent(this, LifeCycleActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(){
        Toast.makeText(this, "Hello from the toast", Toast.LENGTH_LONG).show()
    }

    private fun showSnackBar(){
        val layout = findViewById<ConstraintLayout>(R.id.constrain)
        Snackbar.make(layout, "Hello from the Snackbar", Snackbar.LENGTH_LONG).show()

        //Boton desde un snackbar
        Snackbar.make(layout, "Hello from the Snackbar", Snackbar.LENGTH_LONG).setAction("Undo"){
            Snackbar.make(layout, "Email has been restored", Snackbar.LENGTH_LONG).show()
        }.show()
    }
}