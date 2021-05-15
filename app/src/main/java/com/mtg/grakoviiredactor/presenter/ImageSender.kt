package com.mtg.grakoviiredactor.presenter

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream


class ImageSender {
    fun uploadImage(imageName: String, image: ImageView){
        val storage = Firebase.storage
        val storageReference = storage.getReference()
        val imagesRef: StorageReference = storageReference.child("images/$imageName.png")
        val bitmap = (image.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos)
        val data = baos.toByteArray()

        val uploadTask = imagesRef.putBytes(data)
        uploadTask.
        addOnFailureListener{

        }.
        addOnCompleteListener{

        }
    }
}