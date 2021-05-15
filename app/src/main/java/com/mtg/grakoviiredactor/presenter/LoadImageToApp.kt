package com.mtg.grakoviiredactor.presenter

import com.mtg.grakoviiredactor.model.*

class LoadImageToApp {
    private val classes = mutableListOf<Classes>()
    private val dataProperties = mutableListOf<DataProperty>()
    private val individuals = mutableListOf<Individual>()
    private val objectProperties = mutableListOf<ObjectProperty>()

    fun addClass(name: String, lvl: Int){
        classes.add(Classes(name, lvl))
    }

    fun addData(name: String, result: String){
        dataProperties.add(DataProperty(Data(name), result))
    }

    fun addIndividuals(name: String, classes: Classes, dataProperties: MutableList<DataProperty>,
                       objectProperties: MutableList<ObjectProperty>){
        individuals.add(Individual(name, classes, dataProperties, objectProperties))
    }

    fun addObject(name: String, result: String){
        objectProperties.add(ObjectProperty(Objects(name), result))
    }

    fun getClasses(): MutableList<Classes>{
        return classes
    }
}