package com.mtg.grakoviiredactor.view.main_activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.mtg.grakoviiredactor.R
import com.mtg.grakoviiredactor.model.Classes
import com.mtg.grakoviiredactor.presenter.IndividualAdapter
import com.mtg.grakoviiredactor.presenter.LoadImageToApp
import com.mtg.grakoviiredactor.view.EntityActivity

class IndividualsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var editText: TextInputEditText
    private lateinit var sendButton: FloatingActionButton
    private lateinit var adapter: IndividualAdapter
    private lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mView = inflater.inflate(R.layout.fragment_individuals, container, false)
        loadComponents()
        sendButton.setOnClickListener{onClickButton()}
        return mView
    }

    fun onClickButton(){
        EntityActivity.image.addIndividuals(
            editText.text.toString(),
            Classes("Main Class", 0),
            mutableListOf(),
            mutableListOf()
        )
        adapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    private fun loadComponents(){
        recyclerView = mView.findViewById(R.id.individualsList)
        editText = mView.findViewById(R.id.individualsEditText)
        sendButton = mView.findViewById(R.id.individualsButton)
        adapter = IndividualAdapter(EntityActivity.image.getIndividuals())
        recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            IndividualsFragment().apply {}
    }
}