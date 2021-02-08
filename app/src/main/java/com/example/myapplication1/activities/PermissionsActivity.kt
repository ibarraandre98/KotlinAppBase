package com.example.myapplication1.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : AppCompatActivity() {

    private val requestCameraPermission = 100
    private val requestCameraPicture = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        buttonPicture.setOnClickListener { getPictureFromCameraAskingPermissions() }
    }

    private fun getPictureFromCamera() {
        //Asegurarnos de que no hay permiso de camara en el manifest
        //Crear intent para capturar la foto
        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //Comprobar que podemos manejar la captura de fotos (Tenemos la camara y app de camara)
        if(pictureIntent.resolveActivity(packageManager) != null){
            startActivityForResult(pictureIntent, requestCameraPicture)
        } else {
            //No hay activity que pueda manejar el intent(Sin camara)
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getPictureFromCameraAskingPermissions(){
        //Añadir permiso al manifest
        //Comprobar el permiso de la camara
        if(ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ){
            //Si no ha sido aceptado previamente (Para versiones desde la 6.0 [API 23] en adelante)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), requestCameraPermission)
        } else {
            //Si no ha sido aceptado previamente (Para versiones inferiores a la 6.0 [API 23])
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestCameraPicture)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            requestCameraPermission -> {
                if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Permiso aceptado
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, requestCameraPicture)
                } else {
                    Toast.makeText(this, "No puedes tomar foto", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            requestCameraPicture -> {
                // Comprobar si el resultado es bueno
                if(resultCode == Activity.RESULT_OK){
                    //Obtenemos los extras del intent recibido por parametros
                    val extras = data!!.extras
                    //Formamos el bitmap a partir de los extras
                    val imageBitMap = extras!!.get("data") as Bitmap
                    //Cargamos la foto como bitmap en el imageView
                    imageViewPicture.setImageBitmap(imageBitMap)
                } else {
                    //La foto no ha sido tomada
                    Toast.makeText(this, "La foto no ha sido tomada", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}