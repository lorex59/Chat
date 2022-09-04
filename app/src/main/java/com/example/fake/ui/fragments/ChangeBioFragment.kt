package com.example.fake.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fake.R
import com.example.fake.databinding.FragmentChangeBioBinding
import com.example.fake.utilits.NODE_USERS
import com.example.fake.utilits.REF_DATA_BASE_ROOT
import com.example.fake.utilits.UID
import com.example.fake.utilits.USER

class ChangeBioFragment : BaseChangeFragment(R.layout.fragment_change_bio) {

    private lateinit var binding: FragmentChangeBioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeBioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.settingsInputBio.setText(USER.bio)
    }

    override fun change() {
        REF_DATA_BASE_ROOT.child(NODE_USERS).child(UID).child(bio)
    }

}