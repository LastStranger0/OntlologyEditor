package com.mtg.grakoviiredactor.presenter

import com.mtg.grakoviiredactor.model.*

class LoadImageToApp {
    private val classes = mutableListOf<Classes>()
    private val dataProperties = mutableListOf<DataProperty>()
    private val individuals = mutableListOf<Individual>()
    private val objectProperties = mutableListOf<ObjectProperty>()

    fun addClass(name: String, lvl: Int){
        var canAdd = true
        for(i in classes){
            if (i.name == name){
                canAdd = false
            }
        }
        if(canAdd){
            classes.add(Classes(name, lvl))
        }
    }

    fun addData(name: String, result: String){
        var canAdd = true
        for (i in dataProperties){
            if (i.data.name == name){
                canAdd = false
            }
        }
        if (canAdd){
            dataProperties.add(DataProperty(Data(name), result))
        }
    }

    fun addIndividuals(name: String, classes: Classes, dataProperties: MutableList<DataProperty>,
                       objectProperties: MutableList<ObjectProperty>){
        var canAdd = true
        for (i in individuals){
            if (i.name == name){
                canAdd = false
            }
        }
        if (canAdd){
            individuals.add(Individual(name, classes, dataProperties, objectProperties))
        }
    }

    fun addObject(name: String, result: String){
        var canAdd = true
        for (i in objectProperties){
            if (i.objects.name == name){
                canAdd = false
            }
        }
        if (canAdd){
            objectProperties.add(ObjectProperty(Objects(name), result))
        }
    }

    fun getClasses(): MutableList<Classes>{
        return classes
    }
}