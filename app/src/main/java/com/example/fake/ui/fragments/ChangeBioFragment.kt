package com.example.fake.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fake.R
import com.example.fake.databinding.FragmentChangeBioBinding
import com.example.fake.utilits.*

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
        val newBIO = binding.settingsInputBio.text.toString()
        REF_DATA_BASE_ROOT.child(NODE_USERS).child(CURRENT_UID).child(CHILD_BIO)
            .setValue(newBIO).addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast("Данные обновлены")
                    USER.bio = newBIO
                    parentFragmentManager.popBackStack()
                } else {
                    showToast("Данные необновлены")
                }
            }
    }

}