package com.mtg.grakoviiredactor.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.mtg.grakoviiredactor.R
import com.mtg.grakoviiredactor.presenter.EntityAdapter
import com.mtg.grakoviiredactor.presenter.LoadImageToApp

class EntityActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private lateinit var toolbar: MaterialToolbar
    private lateinit var entityAdapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entity)
        loadComponents()
        entityAdapter = EntityAdapter(image.getClasses())
        recycler.adapter = entityAdapter
        val idToOpen: Int
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

    fun loadComponents(){
        recycler = findViewById(R.id.entityList)
        toolbar = findViewById(R.id.entityActionBar)

    }

    companion object{
        var image = LoadImageToApp()

    }
}