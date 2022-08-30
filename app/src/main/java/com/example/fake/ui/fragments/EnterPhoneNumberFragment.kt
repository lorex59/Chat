package com.example.fake.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fake.R
import com.example.fake.databinding.FragmentEnterCodeBinding
import com.example.fake.databinding.FragmentEnterPhoneNumberBinding


class EnterPhoneNumberFragment : Fragment() {

    private lateinit var binding: FragmentEnterPhoneNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterPhoneNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.registerButtonNext.setOnClickListener { sendCode() }
    }

    private fun sendCode() {
        if (binding.registerInputPhoneNumber.text.toString().isEmpty()) {
            Toast.makeText(activity, "Введите телефон", Toast.LENGTH_SHORT).show()
        } else {
            parentFragmentManager.beginTransaction()
                .replace(R.id.registerContainer, EnterCodeFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}