package com.mtg.grakoviiredactor.view.main_activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mtg.grakoviiredactor.R
import com.mtg.grakoviiredactor.view.EntityActivity

class EntityFragment : Fragment() {

    private lateinit var classButton: FloatingActionButton
    private lateinit var objectPropertiesButton: FloatingActionButton
    private lateinit var dataPropertiesButton: FloatingActionButton
    private lateinit var annotationPropertiesButton: FloatingActionButton
    private lateinit var dataTypesButton: FloatingActionButton
    private lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private val onClickListener = View.OnClickListener{
        val button = it as FloatingActionButton
        val intent = Intent(mContext, EntityActivity::class.java)
        intent.putExtra("NameToOpen", button.id)
        startActivity(intent)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_entity, container, false)
        classButton = view.findViewById(R.id.entityClasses)
        objectPropertiesButton = view.findViewById(R.id.entityObjectProperties)
        dataPropertiesButton = view.findViewById(R.id.entityDataProperties)
        annotationPropertiesButton = view.findViewById(R.id.entityAnnotationProperties)
        dataTypesButton = view.findViewById(R.id.entityDatatypes)

        classButton.setOnClickListener(onClickListener)
        objectPropertiesButton.setOnClickListener(onClickListener)
        dataTypesButton.setOnClickListener(onClickListener)
        dataPropertiesButton.setOnClickListener(onClickListener)
        annotationPropertiesButton.setOnClickListener(onClickListener)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            EntityFragment().apply {}
    }
}