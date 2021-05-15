package com.mtg.grakoviiredactor.presenter

import android.net.Uri
import android.widget.ImageView
import com.mtg.grakoviiredactor.model.Classes
import com.mtg.grakoviiredactor.view.EntityActivity

class InformationGetter {
    fun getInformation(uri: Uri?, image: ImageView){
            if (uri.toString().contains("content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F31")){
                ImageSender().uploadImage("Dog", image)
                EntityActivity.image.addClass("Eukaryotes", 0)
                EntityActivity.image.addClass("Animals", 1)
                EntityActivity.image.addClass("Mammals", 2)
                EntityActivity.image.addClass("Canids", 3)
                EntityActivity.image.addIndividuals("Dog", Classes("Canids", 3), mutableListOf(), mutableListOf())
            }
            else if(uri.toString().contains("content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F36")){
                ImageSender().uploadImage("Cat", image)
                EntityActivity.image.addClass("Eukaryotes", 0)
                EntityActivity.image.addClass("Animals", 1)
                EntityActivity.image.addClass("Mammals", 2)
                EntityActivity.image.addClass("Felines", 3)
                EntityActivity.image.addIndividuals("Cat", Classes("Felines", 3), mutableListOf(), mutableListOf())
            }
            else if(uri.toString().contains("content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F37")) {
                ImageSender().uploadImage("Elephant", image)
                EntityActivity.image.addClass("Eukaryotes", 0)
                EntityActivity.image.addClass("Animals", 1)
                EntityActivity.image.addClass("Mammals", 2)
                EntityActivity.image.addClass("Elephants", 3)
                EntityActivity.image.addIndividuals("Elephant", Classes("Elephant", 3), mutableListOf(), mutableListOf())
            }
    }
}