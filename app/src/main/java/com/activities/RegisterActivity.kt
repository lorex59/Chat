package com.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.fake.R
import com.example.fake.databinding.ActivityRegisterBinding
import com.example.fake.ui.fragments.EnterPhoneNumberFragment
import com.example.fake.ui.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        toolbar = binding.registerToolbar
        setSupportActionBar(toolbar)
        title = getString(R.string.register_title)
        replaceFragment(EnterPhoneNumberFragment())
    }
}