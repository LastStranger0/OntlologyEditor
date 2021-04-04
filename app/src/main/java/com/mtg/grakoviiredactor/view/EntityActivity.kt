package com.mtg.grakoviiredactor.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.MaterialToolbar
import com.mtg.grakoviiredactor.R

class EntityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entity)
        val idToOpen: Int
        val toolbar = findViewById<MaterialToolbar>(R.id.entityActionBar)
        val intent = intent
        setSupportActionBar(toolbar)
        if(intent != null){
            idToOpen = intent.getIntExtra("NameToOpen", 0)
            Log.d("Entity", "work")
            when(idToOpen){
                R.id.entityClasses -> supportActionBar?.setTitle(R.string.classes)
                R.id.entityObjectProperties -> supportActionBar?.setTitle(R.string.objects)
                R.id.entityDataProperties -> supportActionBar?.setTitle(R.string.data)
                R.id.entityAnnotationProperties -> supportActionBar?.setTitle(R.string.annotation)
                R.id.entityDatatypes -> supportActionBar?.setTitle(R.string.datatypes)
            }
        }
    }
}