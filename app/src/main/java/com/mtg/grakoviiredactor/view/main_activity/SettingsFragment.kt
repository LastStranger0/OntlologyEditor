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
import com.mtg.grakoviiredactor.view.UploadImageActivity

class SettingsFragment : Fragment() {

    private lateinit var loadImageBtn: FloatingActionButton
    private lateinit var loadBtn: FloatingActionButton
    private lateinit var saveBtn: FloatingActionButton
    private lateinit var mContext: Context
    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        loadImageBtn = view.findViewById(R.id.loadImageButton)
        loadBtn = view.findViewById(R.id.loadButtonSettings)
        saveBtn = view.findViewById(R.id.saveButtonSettings)

        loadImageBtn.setOnClickListener{onClickLoadImageBtn()}

        return view
    }

    private fun onClickLoadImageBtn(){
        val intent = Intent(mContext, UploadImageActivity::class.java)
        startActivityForResult(intent, loadImageConst)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            loadImageConst -> {

            }
        }
    }

    companion object {
        const val loadImageConst = 1234
        @JvmStatic
        fun newInstance() =
            SettingsFragment().apply {}
    }
}