package com.example.fake.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.fake.R
import com.example.fake.databinding.FragmentEnterCodeBinding
import com.example.fake.ui.utilits.AppTextWatcher
import com.example.fake.ui.utilits.showToast


class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    private lateinit var binding: FragmentEnterCodeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.registerInputPhoneNumber.addTextChangedListener(AppTextWatcher {
            val string = binding.registerInputPhoneNumber.text.toString()
            if (string.length == 6) {
                verifiCode()
            }
        })

    }

    private fun verifiCode() {
        showToast("Ok")
    }

}