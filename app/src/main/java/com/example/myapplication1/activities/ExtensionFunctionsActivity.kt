package com.example.myapplication1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1.MainActivity
import com.example.myapplication1.R
import com.example.myapplication1.others.goToActivity
import com.example.myapplication1.others.snackBar
import com.example.myapplication1.others.toast
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        buttonToast.setOnClickListener { toast("Hola mundo") }
        buttonSnackBar.setOnClickListener { snackBar("I love extension functions", action = "Undo") { toast("Undo!") } }
        buttonLoadByUrl.setOnClickListener {  }
        buttonGoToActivity.setOnClickListener { goToActivity<MainActivity>( { putExtra("Nombre", "André") }) }
    }
}