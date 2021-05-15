package com.mtg.grakoviiredactor.view.main_activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mtg.grakoviiredactor.R

class IndividualsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_individuals, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            IndividualsFragment().apply {}
    }
}