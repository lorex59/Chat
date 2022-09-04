package com.example.fake.ui.fragments

import android.os.Bundle
import android.view.*
import com.example.fake.MainActivity
import com.example.fake.R
import com.example.fake.databinding.FragmentChangeNameBinding
import com.example.fake.ui.utilits.*


class ChangeNameFragment : BaseChangeFragment(R.layout.fragment_change_name) {

    private lateinit var binding: FragmentChangeNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChangeNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initFullNameList()
    }

    private fun initFullNameList() {
        val tempListFullName = USER.fullname.split(" ")
        if (tempListFullName.size > 1) {
            binding.settingsInputName.setText(tempListFullName[0])
            binding.settingsInputSurname.setText(tempListFullName[1])
        } else {
            binding.settingsInputName.setText(tempListFullName[0])
        }
    }


    override fun change() {
        val name = binding.settingsInputName.text.toString()
        val surname = binding.settingsInputSurname.text.toString()
        if (name.isEmpty()) {
            showToast("Имя необходимо заполнить")
        } else {
            val fullName = "$name $surname"
            REF_DATA_BASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULLNAME)
                .setValue(fullName).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast("Данные обновлены")
                        USER.fullname = fullName
                        activity?.supportFragmentManager?.popBackStack()
                    } else {
                        showToast("Данные необновлены")
                    }
                }
        }
    }


}