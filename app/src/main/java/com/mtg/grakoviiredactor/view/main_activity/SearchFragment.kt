package com.mtg.grakoviiredactor.view.main_activity

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.mtg.grakoviiredactor.R
import com.mtg.grakoviiredactor.model.*
import com.mtg.grakoviiredactor.presenter.IndividualAdapter

class SearchFragment : Fragment() {

    lateinit var mContext: Context
    lateinit var mView: View

    lateinit var searchText: TextInputEditText
    lateinit var searchButton: FloatingActionButton
    lateinit var searchList: RecyclerView

    lateinit var resultList: MutableList<Individual>
    lateinit var resultAdapter: IndividualAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_search, container, false)
        searchButton = mView.findViewById(R.id.searchButton)
        searchText = mView.findViewById(R.id.searchEditText)
        searchList = mView.findViewById(R.id.searchList)
        resultList = mutableListOf(Individual("Individual",
                Classes("Class", 0), mutableListOf(DataProperty(Data("main"), "nu")),
                mutableListOf(ObjectProperty(Objects("main1"), "na"))),
        Individual("Individual",
                Classes("Class", 0), mutableListOf(DataProperty(Data("main"), "nu")),
                mutableListOf(ObjectProperty(Objects("main1"), "na"))),
        Individual("Individual",
                Classes("Class", 0), mutableListOf(DataProperty(Data("main"), "nu")),
                mutableListOf(ObjectProperty(Objects("main1"), "na"))))
        resultAdapter = IndividualAdapter(resultList)
        searchList.adapter = resultAdapter

        return mView
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SearchFragment().apply {}
    }
}