package com.mtg.grakoviiredactor.presenter

import android.util.Log
import org.fastily.jwiki.core.Wiki
import org.fastily.jwiki.core.*
import org.fastily.jwiki.dwrap.*

class WikiLoader {
    fun loadFrom(name: String): MutableList<String>{
        val wiki = Wiki.Builder().build()
        return parseString(wiki.getPageText(name))
    }
    fun parseString(text: String): MutableList<String>{
        val strings = mutableListOf<String>()
        if (text.contentEquals("Family")){
            strings.add(text.substring(text.indexOf("Family"), text.indexOf('\n')))
        }

        if (text.contentEquals("Kingdom")){
            strings.add(text.substring(text.indexOf("Kingdom"), text.indexOf('\n')))
        }

        if (text.contentEquals("Domain")){
            strings.add(text.substring(text.indexOf("Domain"), text.indexOf('\n')))
        }

        if (text.contentEquals("Class")){
            strings.add(text.substring(text.indexOf("Class"), text.indexOf('\n')))
        }
        return strings
    }
}