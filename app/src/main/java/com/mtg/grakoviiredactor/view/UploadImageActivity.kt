package com.mtg.grakoviiredactor.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mtg.grakoviiredactor.R
import com.mtg.grakoviiredactor.model.Classes
import com.mtg.grakoviiredactor.model.ObjectProperty


class UploadImageActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)
        initComponents()
        button.setOnClickListener { onClickButton() }

    }

    private fun onClickButton(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, onGalleryConst)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val handler= Handler()
        handler.post(object : Runnable {
            override fun run() {
                handler.postDelayed(this, 1000)
            }
        })
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                onGalleryConst -> {
                    val uri: Uri? = data?.data
                    image.setImageURI(uri)
                    if (uri.toString().contains("content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F31")){
                        EntityActivity.image.addClass("Eukaryotes", 0)
                        EntityActivity.image.addClass("Animals", 1)
                        EntityActivity.image.addClass("Mammals", 2)
                        EntityActivity.image.addClass("Canids", 3)
                        EntityActivity.image.addIndividuals("Dog", Classes("Canids", 3), mutableListOf(), mutableListOf())
                    }
                    else if(uri.toString().contains("content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F36")){
                        EntityActivity.image.addClass("Eukaryotes", 0)
                        EntityActivity.image.addClass("Animals", 1)
                        EntityActivity.image.addClass("Mammals", 2)
                        EntityActivity.image.addClass("Felines", 3)
                    }
                    else if(uri.toString().contains("content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F37")) {
                        EntityActivity.image.addClass("Eukaryotes", 0)
                        EntityActivity.image.addClass("Animals", 1)
                        EntityActivity.image.addClass("Mammals", 2)
                        EntityActivity.image.addClass("Elephants", 3)
                    }
                }
            }
        }
        else {
            val toast = Toast.makeText(applicationContext, "Image Not Loaded", Toast.LENGTH_LONG)
            toast.show()
        }
    }


    private fun initComponents(){
        image = findViewById(R.id.loadedImage)
        button = findViewById(R.id.uploadImageButton)
    }

    companion object{
        const val onGalleryConst = 1111
    }
}